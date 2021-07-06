package com.quiz.solution.acm_icpc;

import java.util.Scanner;

public class Problem1292 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();

        solve(a, b);
    }

    public static void solve(int a, int b) {
        int p = 1;
        int count = 0;
        int result = 0;

        for (int i = 1; i <= 1_000; i++) {
            if (a <= i && i <= b) {
                result += p;
            } else if (b < i) {
                break;
            }

            count++;

            if (count == p) {
                p++;
                count = 0;
            }
        }

        System.out.println(result);
    }
}
