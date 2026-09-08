package io.github.cdiamondgit.tvfinder;

public class UserPreferredTelevision {

    // user can enter a preffered brand/ecosystem, or no preference
    private String userPrefBrand;

    // calculate feature points separately from price, then use price at end to whittle down results
    // two categories - strict budget and max budget, each with two categories - best value for money and best raw score
    private double userPrefBudget;
    private double userMaxBudget;
    
    // user gets two choices - choose by general size (small, medium, large) OR choose by range
    // they can then choose to stay strict or have flexibility (flexibility in larger and smaller OR only smaller OR only larger)
    private int userMaxSizeInches;
    private int userMinSizeInches;

    // user can choose to have or not have this as a weighted field for the score
    // if they choose to include it, they can choose from three options - "Guide me", "I know what I want", "Show me the tech"
    private int userRefreshRateHz;
    private boolean considerRefreshRate;

    // user can choose to have or not have this as a weighted field for the score
    // if they choose to include it, they can choose from three options - "Guide me", "I know what I want", "Show me the tech"
    private String userDisplayType;
    private boolean considerDisplayType;

    public UserPreferredTelevision(String userPrefBrand, double userPrefBudget, double userMaxBudget, int userMaxSizeInches, int userMinSizeInches, int userRefreshRateHz, String userDisplayType, boolean considerRefreshRate, boolean considerDisplayType) {
        this.userPrefBrand = userPrefBrand;
        this.userPrefBudget = userPrefBudget;
        this.userMaxBudget = userMaxBudget;
        this.userMaxSizeInches = userMaxSizeInches;
        this.userMinSizeInches = userMinSizeInches;
        this.userRefreshRateHz = userRefreshRateHz;
        this.userDisplayType = userDisplayType;
        this.considerRefreshRate = considerRefreshRate;
        this.considerDisplayType = considerDisplayType;
    }

    public String getUserPrefBrand() {
        return userPrefBrand;
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

    public int getUserRefreshRateHz() {
        return userRefreshRateHz;
    }   

    public String getUserDisplayType() {
        return userDisplayType;
    }

    public double getUserMaxBudget() {
        return userMaxBudget;
    }

    public boolean getConsiderRefreshRate() {
        return considerRefreshRate;
    }

    public boolean getConsiderDisplayType() {
        return considerDisplayType;
    }
}