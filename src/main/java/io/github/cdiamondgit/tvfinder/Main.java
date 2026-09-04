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

        Television tv1 = new Television("LG", "C6", 1199, 55, 120, "OLED");
        Television tv2 = new Television("Samsung", "QN90F", 1099, 55, 144, "Mini-LED");
        Television tv3 = new Television("Sony", "A95L", 1599, 55, 120, "QD-OLED");
        Television tv4 = new Television("TCL", "C8K", 899, 55, 144, "Mini-LED");
        Television tv5 = new Television("Hisense", "U7Q", 749, 55, 144, "Mini-LED");

        televisions.add(tv1);
        televisions.add(tv2);
        televisions.add(tv3);
        televisions.add(tv4);
        televisions.add(tv5);

        System.out.println("Enter brand: ");
        userBrand = scanner.next();

        System.out.println("Enter price: ");
        userPrice = scanner.nextDouble();

        System.out.println("Enter size: ");
        userSizeInches = scanner.nextInt();

        System.out.println("Enter Refresh Rate: ");
        userRefreshRateHz = scanner.nextInt();

        System.out.println("Enter display type: ");
        userDisplayType = scanner.next();

        UserPreferredTelevision userTv = new UserPreferredTelevision(userBrand, userPrice, userSizeInches, userRefreshRateHz, userDisplayType);

        scanner.close();
    }
}