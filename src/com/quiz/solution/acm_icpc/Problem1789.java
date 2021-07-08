package com.quiz.solution.acm_icpc;

import java.util.Scanner;

public class Problem1789 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();

        solve(input);
    }

    public static void timeLapse(long input) { // TODO: lambda expression
        long start = System.currentTimeMillis();
        solve(input);
        System.out.println("TimeLapse: " + (System.currentTimeMillis() - start));
    }

    public static void solve(long input) {
        long result = 0;
        for (int i = 1; i <= input; i++) {
            result += i;

            if (input < result + (i + 1)) {
                System.out.print(i);
                break;
            }
        }
    }
}
