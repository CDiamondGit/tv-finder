package io.github.cdiamondgit.tvfinder;

import java.util.Set;

public class UserPreferredTelevision {

    // user can enter preffered brands/ecosystems, or no preference
    private Set<String> userBrands;
    private PreferenceLevel brandPreferenceLevel;

    // calculate feature points separately from price, then use price at end to whittle down results
    // two categories - strict budget and max budget, each with two categories - best value for money and best raw score
    private double userPrefBudget;
    private double userMaxBudget;
    
    // user gets two choices - choose by general size (small, medium, large) OR choose by range
    // they can then choose to stay strict or have flexibility (flexibility in larger and smaller OR only smaller OR only larger)
    private int userMinSizeInches;
    private int userMaxSizeInches;

    // user can choose to have or not have this as a weighted field for the score
    // if they choose to include it, they can choose from three options - "Guide me", "I know what I want", "Show me the tech"
    private Set<Integer> userRefreshRates;
    private PreferenceLevel refreshRatePreferenceLevel;

    // user can choose to have or not have this as a weighted field for the score
    // if they choose to include it, they can choose from three options - "Guide me", "I know what I want", "Show me the tech"
    private Set<String> userDisplayTypes;
    private PreferenceLevel displayTypePreferenceLevel;

    public UserPreferredTelevision(Set<String> userBrands, PreferenceLevel brandPreferenceLevel, double userPrefBudget, double userMaxBudget, int userMinSizeInches, int userMaxSizeInches, Set<Integer> userRefreshRates, PreferenceLevel refreshRatePreferenceLevel, Set<String> userDisplayTypes, PreferenceLevel displayTypePreferenceLevel) {
        this.userBrands = userBrands;
        this.brandPreferenceLevel = brandPreferenceLevel;
        this.userPrefBudget = userPrefBudget;
        this.userMaxBudget = userMaxBudget;
        this.userMinSizeInches = userMinSizeInches;
        this.userMaxSizeInches = userMaxSizeInches;
        this.userRefreshRates = userRefreshRates;
        this.refreshRatePreferenceLevel = refreshRatePreferenceLevel;
        this.userDisplayTypes = userDisplayTypes;
        this.displayTypePreferenceLevel = displayTypePreferenceLevel;
    }

    public Set<String> getUserBrands() {
        return userBrands;
    }

    public double getUserPrefBudget() {
        return userPrefBudget;
    }   

    public int getUserMaxSizeInches() {
        return userMaxSizeInches;
    }  

    public int getUserMinSizeInches() {
        return userMinSizeInches;
    }    

    public Set<Integer> getUserRefreshRates() {
        return userRefreshRates;
    }   

    public Set<String> getUserDisplayTypes() {
        return userDisplayTypes;
    }

    public double getUserMaxBudget() {
        return userMaxBudget;
    }

    public PreferenceLevel getBrandPreferenceLevel() {
        return brandPreferenceLevel;
    }

    public PreferenceLevel getRefreshRatePreferenceLevel() {
        return refreshRatePreferenceLevel;
    }

    public PreferenceLevel getDisplayTypePreferenceLevel() {
        return displayTypePreferenceLevel;
    }
}