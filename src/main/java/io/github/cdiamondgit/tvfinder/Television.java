package io.github.cdiamondgit.tvfinder;

public class Television {
    private String brand;
    private String model;
    private double price;
    private int sizeInches;
    private int refreshRateHz;
    private String displayType;

    public Television(String brand, String model, double price, int sizeInches, int refreshRateHz, String displayType) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.sizeInches = sizeInches;
        this.refreshRateHz = refreshRateHz;
        this.displayType = displayType;
    }

    public void printTv() {
        System.out.println(this.getBrand() + "-" + this.getModel());
        System.out.println("Price: €" + this.getPrice());
        System.out.println("Size: " + this.getSizeInches() + "\"");
        System.out.println("Refresh Rate: " + this.getRefreshRateHz() + "Hz");
        System.out.println("Display Type: " + this.getDisplayType());
    }

    public String getBrand() {
        return brand;
    }   

    public String getModel() {
        return model;
    }   

    public double getPrice() {
        return price;
    }   

    public int getSizeInches() {
        return sizeInches;
    }   

    public int getRefreshRateHz() {
        return refreshRateHz;
    }   

    public String getDisplayType() {
        return displayType;
    }
}