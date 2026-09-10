package io.github.cdiamondgit.tvfinder;

import java.util.ArrayList;
import java.util.List;

public class RecommendationEngine {

    public Recommendation calculateRecommendation(List <Television> televisions, UserPreferredTelevision userTv) {
        List <Recommendation> recommendations = new ArrayList<>();
        int totalImportanceWeight = userTv.getDisplayTypePreferenceLevel().getImportanceWeight() + userTv.getRefreshRatePreferenceLevel().getImportanceWeight() + userTv.getBrandPreferenceLevel().getImportanceWeight();

    for (Television television : televisions) {
        double score = 0;

        if (userTv.getBrandPreferenceLevel() == PreferenceLevel.ESSENTIAL) {
            if (!userTv.getUserBrands().contains(television.getBrand())) {
                continue;
            }
        } else if (userTv.getBrandPreferenceLevel() != PreferenceLevel.NO_PREFERENCE) {
            score += calculateBrand(television, userTv, totalImportanceWeight);
        }

        if (television.getPrice() <= userTv.getUserMaxBudget()) {
            score += 20;
        } else {
            continue;
        }

        if (television.getSizeInches() >= userTv.getUserMinSizeInches()
                && television.getSizeInches() <= userTv.getUserMaxSizeInches()) {
            score += 20;
        } else {
            continue;
        }

        if (userTv.getRefreshRatePreferenceLevel() != PreferenceLevel.NO_PREFERENCE) {
            if (userTv.getUserRefreshRates().contains(television.getRefreshRate())) {
                score += 20;
            } else {
                score += 10;
            }
        }

        if (userTv.getDisplayTypePreferenceLevel() != PreferenceLevel.NO_PREFERENCE) {
            if (userTv.getUserDisplayTypes().contains(television.getDisplayType())) {
                score += 15;
            }
        }

        recommendations.add(new Recommendation(television, score));
    }

    Recommendation bestRecommendation = recommendations.get(0);
        for (Recommendation recommendation : recommendations) {
            if (recommendation.getScore() > bestRecommendation.getScore()) {
                bestRecommendation = recommendation;
            }
        }

        return bestRecommendation;
    }

    private double calculateBrand(Television television, UserPreferredTelevision userTv, int totalImportanceWeight) {
        double brandScore = 0;

        if (userTv.getUserBrands().contains(television.getBrand())) {
            brandScore = userTv.getBrandPreferenceLevel().getImportanceWeight() * 100.0 / totalImportanceWeight;
        }

        return brandScore;
    }
}