package org.example;

import java.util.Scanner;

public class ScientificCalculatorTest {

    public static void main(String[] args) {
        // Your existing menu logic calling the methods below
    }

    // This is the method the test is looking for
    public static double sqrt(double x) {
        return Math.sqrt(x);
    }

    public static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}