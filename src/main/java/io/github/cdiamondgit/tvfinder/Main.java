package io.github.cdiamondgit.tvfinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userBrand;
        double userPrice;
        int userSizeInches;
        int userRefreshRateHz;
        String userDisplayType;

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

        System.out.print("Enter brand: ");
        userBrand = scanner.next();

        System.out.print("Enter price: ");
        userPrice = scanner.nextDouble();

        System.out.print("Enter size: ");
        userSizeInches = scanner.nextInt();

        System.out.print("Enter Refresh Rate: ");
        userRefreshRateHz = scanner.nextInt();

        System.out.print("Enter display type: ");
        userDisplayType = scanner.next();

        UserPreferredTelevision userTv = new UserPreferredTelevision(userBrand, userPrice, userSizeInches, userRefreshRateHz, userDisplayType);

        RecommendationEngine recommendationEngine = new RecommendationEngine(televisions);
        
        Recommendation bestRecommendation = recommendationEngine.calculateRecommendation(userTv);

        bestRecommendation.getTelevision().printTv();

        scanner.close();
    }
}