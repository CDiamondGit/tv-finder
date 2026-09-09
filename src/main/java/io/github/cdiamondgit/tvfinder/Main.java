package io.github.cdiamondgit.tvfinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> userPrefBrands = new HashSet<>(); // stores unique strings and provides fast membership checks during recommendation scoring
        boolean considerBrand = true;

        double userPrefBudget;
        double userMaxBudget;

        int userMinSizeInches;
        int userMaxSizeInches;

        Set<Integer> userRefreshRates = new HashSet<>();
        boolean considerRefreshRate = true;

        Set<String> userDisplayTypes = new HashSet<>();
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

        // BRAND 

        System.out.print("Brand preference:\n"
        + "1. No preference\n"
        + "2. Choose brands\n");

        if (scanner.nextInt() == 1) {
            considerBrand = false;
        } else {
            considerBrand = true;

            scanner.nextLine();

            System.out.print("Choose preferred brands:\n"
                    + "1. LG\n"
                    + "2. Samsung\n"
                    + "3. Sony\n"
                    + "4. TCL\n"
                    + "5. Hisense\n"
                    + "Enter choices (e.g. 1 2): ");

            String brandChoices = scanner.nextLine();

            if (brandChoices.contains("1")) {
                userPrefBrands.add("LG");
            }

            if (brandChoices.contains("2")) {
                userPrefBrands.add("Samsung");
            }

            if (brandChoices.contains("3")) {
                userPrefBrands.add("Sony");
            }

            if (brandChoices.contains("4")) {
                userPrefBrands.add("TCL");
            }

            if (brandChoices.contains("5")) {
                userPrefBrands.add("Hisense");
            }
        }

        // BUDGET 

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

        // SIZE 

        System.out.print("Size preference:\n"
                + "1. Choose general size\n"
                + "2. Choose custom range\n");

        if (scanner.nextInt() == 1) {
            System.out.print("Choose general size:\n"
                    + "1. Small (32\"-43\")\n"
                    + "2. Medium (44\"-55\")\n"
                    + "3. Large (56\"-75\")\n");

            int sizeChoice = scanner.nextInt();

            if (sizeChoice == 1) {
                userMinSizeInches = 32;
                userMaxSizeInches = 43;
            } else if (sizeChoice == 2) {
                userMinSizeInches = 44;
                userMaxSizeInches = 55;
            } else {
                userMinSizeInches = 56;
                userMaxSizeInches = 75;
            }
        } else {
            System.out.print("Enter minimum size (inches): ");
            userMinSizeInches = scanner.nextInt();

            System.out.print("Enter maximum size (inches): ");
            userMaxSizeInches = scanner.nextInt();
        }

        // REFRESH RATE 

        System.out.print("Refresh rate preference:\n"
                + "1. No preference\n"
                + "2. Choose refresh rates\n");

        if (scanner.nextInt() == 1) {
            considerRefreshRate = false;
        } else {
            considerRefreshRate = true;

            scanner.nextLine();

            System.out.print("Choose preferred refresh rates:\n"
                    + "1. 60Hz\n"
                    + "2. 120Hz\n"
                    + "3. 144Hz\n"
                    + "Enter choices (e.g. 1 2): ");

            String refreshRateChoices = scanner.nextLine();

            if (refreshRateChoices.contains("1")) {
                userRefreshRates.add(60);
            }

            if (refreshRateChoices.contains("2")) {
                userRefreshRates.add(120);
            }

            if (refreshRateChoices.contains("3")) {
                userRefreshRates.add(144);
            }
        }

        // DISPLAY TYPE 

        System.out.print("Display type preference:\n"
                + "1. No preference\n"
                + "2. Choose display types\n");

        if (scanner.nextInt() == 1) {
            considerDisplayType = false;
        } else {
            considerDisplayType = true;

            scanner.nextLine();

            System.out.print("Choose preferred display types:\n"
                    + "1. OLED\n"
                    + "2. QD-OLED\n"
                    + "3. Mini-LED\n"
                    + "4. QLED\n"
                    + "Enter choices (e.g. 1 3): ");

            String displayTypeChoices = scanner.nextLine();

            if (displayTypeChoices.contains("1")) {
                userDisplayTypes.add("OLED");
            }

            if (displayTypeChoices.contains("2")) {
                userDisplayTypes.add("QD-OLED");
            }

            if (displayTypeChoices.contains("3")) {
                userDisplayTypes.add("Mini-LED");
            }

            if (displayTypeChoices.contains("4")) {
                userDisplayTypes.add("QLED");
            }
        }

        UserPreferredTelevision userTv = new UserPreferredTelevision(userPrefBrands, considerBrand, userPrefBudget, userMaxBudget, userMinSizeInches, userMaxSizeInches, userRefreshRates, considerRefreshRate, userDisplayTypes, considerDisplayType);

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