package com.test;

import java.util.Scanner;

/**
 * Created by YaoWang on 2018/1/2.
 *
 * Checkout System
 */
public class CheckoutTest {
    private static double totalPay = 0;
    private static double applePrice = 0.6;
    private static double orangePrice = 0.25;

    public static void main(String[] args) {

        System.out.println("Please input your items:");
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] strings = string.split(",");

//        getPay(strings);

        getOffers(strings);

    }

    /**
     * Step1: Shopping cart
     *
     * @param strings
     */
    private static void getPay(String[] strings) {

        for (String s : strings) {
            if (s.trim().equalsIgnoreCase("apple")) {
                totalPay += applePrice;
            } else if (s.trim().equalsIgnoreCase("orange")) {
                totalPay += orangePrice;
            }
        }
        System.out.println("The total is: " + totalPay);
    }

    /**
     * Step2: Simple offers
     *
     * @param strings
     */
    private static void getOffers(String[] strings) {

        int appleNum = 0;
        int orangeNum = 0;

        for (String s : strings) {
            if (s.trim().equalsIgnoreCase("apple")) {
                appleNum++;
                if (appleNum % 2 != 0) { // buy one and get one free
                    totalPay += applePrice;
                }
            } else if (s.trim().equalsIgnoreCase("orange")) {
                orangeNum++;
                if (orangeNum % 3 != 0) { // new offers
                    totalPay += orangePrice;
                } else {
                    orangeNum = 0;
                }
            }
        }
        System.out.println("The total is: " + totalPay);
    }
}
