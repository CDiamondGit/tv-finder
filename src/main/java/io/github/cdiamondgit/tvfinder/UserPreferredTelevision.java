package io.github.cdiamondgit.tvfinder;

public class UserPreferredTelevision {
    private String userBrand;
    private double userPrice;
    private int userSizeInches;
    private int userRefreshRateHz;
    private String userDisplayType;

    public UserPreferredTelevision(String userBrand, double userPrice, int userSizeInches, int userRefreshRateHz, String userDisplayType) {
        this.userBrand = userBrand;
        this.userPrice = userPrice;
        this.userSizeInches = userSizeInches;
        this.userRefreshRateHz = userRefreshRateHz;
        this.userDisplayType = userDisplayType;
    }

    public String getUserBrand() {
        return userBrand;
    }

    public double getUserPrice() {
        return userPrice;
    }   

    public int getUserSizeInches() {
        return userSizeInches;
    }   

    public int getUserRefreshRateHz() {
        return userRefreshRateHz;
    }   

    public String getUserDisplayType() {
        return userDisplayType;
    }
}