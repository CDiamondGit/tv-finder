package io.github.cdiamondgit.tvfinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userPrefBrand;
        double userPrefBudget;
        int userRefreshRateHz;
        String userDisplayType;
        double userMaxBudget;
        int userMaxSizeInches;
        int userMinSizeInches;
        boolean considerRefreshRate = true;
        boolean considerDisplayType = true;

        List<Television> televisions = new ArrayList<>();

        // temporary test data

        Television tv1 = new Television("LG", "C6", 1199, 55, 120, "OLED");
        Television tv2 = new Television("Samsung", "QN90F", 1099, 55, 144, "Mini-LED");
        Television tv3 = new Television("Sony", "A95L", 1599, 55, 120, "QD-OLED");
        Television tv4 = new Television("TCL", "C8K", 899, 55, 144, "Mini-LED");
        Television tv5 = new Television("Hisense", "U7Q", 749, 55, 144, "Mini-LED");
        Television tv6 = new Television("LG", "B6", 899, 55, 120, "OLED");
        Television tv7 = new Television("Samsung", "Q80F", 799, 55, 120, "QLED");
        Television tv8 = new Television("Sony", "Bravia 7", 1399, 65, 120, "Mini-LED");
        Television tv9 = new Television("TCL", "C6K", 699, 65, 144, "Mini-LED");
        Television tv10 = new Television("Hisense", "E7Q", 549, 50, 60, "QLED");

        televisions.add(tv1);
        televisions.add(tv2);
        televisions.add(tv3);
        televisions.add(tv4);
        televisions.add(tv5);
        televisions.add(tv6);
        televisions.add(tv7);
        televisions.add(tv8);
        televisions.add(tv9);
        televisions.add(tv10);

        System.out.print("Do you have a preferred TV brand?\n"
        + "1. No preference\n"
        + "2. LG\n"
        + "3. Samsung\n"
        + "4. Sony\n"
        + "5. TCL\n"
        + "6. Hisense\n"
        + "7. Other\n"
        + "Enter choice: ");

        int brandChoice = scanner.nextInt();

        if (brandChoice == 1) {
            userPrefBrand = "";
        } else if (brandChoice == 2) {
            userPrefBrand = "LG";
        } else if (brandChoice == 3) {
            userPrefBrand = "Samsung";
        } else if (brandChoice == 4) {
            userPrefBrand = "Sony";
        } else if (brandChoice == 5) {
            userPrefBrand = "TCL";
        } else if (brandChoice == 6) {
            userPrefBrand = "Hisense";
        } else {
            System.out.print("Enter brand: ");
            userPrefBrand = scanner.next();
        }

        System.out.print("What is your preferred budget? (€): ");
        userPrefBudget = scanner.nextDouble();

        System.out.print("How flexible is your budget?\n"
        + "1. Strict\n"
        + "2. Flexible\n");

        if(scanner.nextInt() == 2) {
            System.out.println("How flexible is your budget?");
            System.out.println("10% - up to €" + userPrefBudget * 1.10);
            System.out.println("20% - up to €" + userPrefBudget * 1.20);
            System.out.println("30% - up to €" + userPrefBudget * 1.30);
            System.out.println("40% - up to €" + userPrefBudget * 1.40);
            System.out.println("50% - up to €" + userPrefBudget * 1.50);
            System.out.print("Enter percentage: ");
            int flexibilityPercent = scanner.nextInt();
            userMaxBudget = userPrefBudget * (1 + flexibilityPercent / 100.0);
        } else {
            userMaxBudget = userPrefBudget;
        }

        System.out.print("How would you like to choose TV size?\n"
                + "1. Small (32\"-43\")\n"
                + "2. Medium (44\"-55\")\n"
                + "3. Large (56\"-75\")\n"
                + "4. Choose a size range\n");

        int sizeChoice = scanner.nextInt();

        if (sizeChoice == 1) {
            userMinSizeInches = 32;
            userMaxSizeInches = 43;
        } else if (sizeChoice == 2) {
            userMinSizeInches = 44;
            userMaxSizeInches = 55;
        } else if (sizeChoice == 3) {
            userMinSizeInches = 56;
            userMaxSizeInches = 75;
        } else {
            System.out.print("Enter minimum size (inches): ");
            userMinSizeInches = scanner.nextInt();

            System.out.print("Enter maximum size (inches): ");
            userMaxSizeInches = scanner.nextInt();
        }

        System.out.print("Refresh rate:\n"
                + "1. No preference\n"
                + "2. Include\n");

        if (scanner.nextInt() == 2) {
            considerRefreshRate = true;

            System.out.print("Choose refresh rate:\n"
                    + "1. 60Hz\n"
                    + "2. 120Hz\n"
                    + "3. 144Hz\n");

            int refreshRateChoice = scanner.nextInt();

            if (refreshRateChoice == 1) {
                userRefreshRateHz = 60;
            } else if (refreshRateChoice == 2) {
                userRefreshRateHz = 120;
            } else {
                userRefreshRateHz = 144;
            }
        } else {
            considerRefreshRate = false;
            userRefreshRateHz = 0;
        }

        System.out.print("Display type:\n"
                + "1. No preference\n"
                + "2. Include\n");

        if (scanner.nextInt() == 2) {
            considerDisplayType = true;

            System.out.print("Choose display type:\n"
                    + "1. OLED\n"
                    + "2. QD-OLED\n"
                    + "3. Mini-LED\n"
                    + "4. QLED\n");

            int displayTypeChoice = scanner.nextInt();

            if (displayTypeChoice == 1) {
                userDisplayType = "OLED";
            } else if (displayTypeChoice == 2) {
                userDisplayType = "QD-OLED";
            } else if (displayTypeChoice == 3) {
                userDisplayType = "Mini-LED";
            } else {
                userDisplayType = "QLED";
            }
        } else {
            considerDisplayType = false;
            userDisplayType = "";
        }

        UserPreferredTelevision userTv = new UserPreferredTelevision(userPrefBrand, userPrefBudget, userMaxBudget, userMaxSizeInches, userMinSizeInches, userRefreshRateHz, userDisplayType, considerRefreshRate, considerDisplayType);

        RecommendationEngine recommendationEngine = new RecommendationEngine();
        List<Recommendation> recommendations = new ArrayList<>();

        for (Television television : televisions) {
            recommendations.add(new Recommendation(television, 0));
        }
        
        Recommendation bestRecommendation = recommendationEngine.calculateRecommendation(recommendations, userTv);

        bestRecommendation.getTelevision().printTv();

        scanner.close();
    }
}