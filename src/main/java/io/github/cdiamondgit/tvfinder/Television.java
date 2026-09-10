package io.github.cdiamondgit.tvfinder;

public class Television {
    private String brand;
    private String model;
    private double price;
    private int sizeInches;
    private int refreshRate;
    private String displayType;

    public Television(String brand, String model, double price, int sizeInches, int refreshRate, String displayType) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.sizeInches = sizeInches;
        this.refreshRate = refreshRate;
        this.displayType = displayType;
    }

    public void printTv() {
        System.out.println(this.brand + "-" + this.model);
        System.out.println("Price: €" + this.price);
        System.out.println("Size: " + this.sizeInches + "\"");
        System.out.println("Refresh Rate: " + this.refreshRate + "Hz");
        System.out.println("Display Type: " + this.displayType);
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

    public int getRefreshRate() {
        return refreshRate;
    }   

    public String getDisplayType() {
        return displayType;
    }
}