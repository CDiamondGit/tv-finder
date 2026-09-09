package io.github.cdiamondgit.tvfinder;

import java.util.List;

public class RecommendationEngine {

    public Recommendation calculateRecommendation(List<Recommendation> recommendations, UserPreferredTelevision userTv) {
        for (Recommendation recommendation : recommendations) {
            int score = 0;

            if (userTv.getConsiderBrand()) {
                if (userTv.getUserPrefBrands().contains(recommendation.getTelevision().getBrand())) {
                    score += 15;
                }
            }

            if (recommendation.getTelevision().getPrice() <= userTv.getUserMaxBudget()) {
                score += 20;
            } else {
                recommendation.setScore(score);
                continue;
            }

            if (recommendation.getTelevision().getSizeInches() >= userTv.getUserMinSizeInches()
                    && recommendation.getTelevision().getSizeInches() <= userTv.getUserMaxSizeInches()) {
                score += 20;
            } else {
                recommendation.setScore(score);
                continue;
            }

            if (userTv.getConsiderRefreshRate()) {
                if (userTv.getUserRefreshRates().contains(recommendation.getTelevision().getRefreshRateHz())) {
                    score += 20;
                } else {
                    score += 10;
                }
            }

            if (userTv.getConsiderDisplayType()) {
                if (userTv.getUserDisplayTypes().contains(recommendation.getTelevision().getDisplayType())) {
                    score += 15;
                }
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