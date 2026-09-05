package io.github.cdiamondgit.tvfinder;

import java.util.ArrayList;
import java.util.List;

public class RecommendationEngine {
    private List<Recommendation> recommendations = new ArrayList<>();
    
    public RecommendationEngine(List<Television> televisions) {
        for (Television television : televisions) {
            recommendations.add(new Recommendation(television, 0));
        }
    }

    public Recommendation calculateRecommendation(UserPreferredTelevision userTv) {
        for (Recommendation recommendation : recommendations) {
            int score = 0; 

            if (userTv.getUserBrand().equals(recommendation.getTelevision().getBrand())) {
                score += 15;
            }

            if (recommendation.getTelevision().getPrice() <= userTv.getUserPrice()) {
                score += 20;
            } else if (recommendation.getTelevision().getPrice() < userTv.getUserPrice() * 1.2){
                score += 10;
            } else {
                recommendation.setScore(score);
                continue;
            }

            if (userTv.getUserSizeInches() == recommendation.getTelevision().getSizeInches()) {
                score += 20;
            } else if (userTv.getUserSizeInches() * 1.2 > recommendation.getTelevision().getSizeInches() && userTv.getUserSizeInches() * 0.8 < recommendation.getTelevision().getSizeInches()) {
                score += 10;
            } else {
                score += 5;
            }

            if (recommendation.getTelevision().getRefreshRateHz() >= userTv.getUserRefreshRateHz()) {
                score += 20;
            } else {
                score += 10;
            } 

            if (userTv.getUserDisplayType().equals(recommendation.getTelevision().getDisplayType())) {
                score += 15;
            }

            recommendation.setScore(score);
        }

        Recommendation bestRecommendation = recommendations.get(0);
        for (Recommendation recommendation : recommendations) {
            if (recommendation.getScore() > bestRecommendation.getScore()) {
                bestRecommendation = recommendation;
            }
        }

        return bestRecommendation;
    }
}