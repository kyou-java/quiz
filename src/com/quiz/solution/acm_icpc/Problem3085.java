package com.quiz.solution.acm_icpc;

import java.util.Arrays;
import java.util.Scanner;

public class Problem3085 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.valueOf(scanner.nextLine());

        String[][] input = new String[count][count];

        for (int i = 0; i < count; i++) {
            input[i] = scanner.nextLine().split("");
        }

        solve(input);
    }

    public static void solve(String[][] input) {
        for (String[] i : input) {
            System.out.println(Arrays.toString(i));
        }
    }
}
