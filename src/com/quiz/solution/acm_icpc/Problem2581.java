package com.quiz.solution.acm_icpc;

import java.util.Scanner;

public class Problem2581 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        solve(m, n);
    }

    // M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
    // M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
    public static void solve(int m, int n) {
        // long start = System.currentTimeMillis();
        // System.out.println("start: " + start);

        boolean find = false;
        int sum = 0;
        int min = 0;

        for (int i = m; i <= n; i++) {
            if (isPrimeNumber(i)) {
                if (!find) {
                    min = i;
                }
                sum += i;
                find = true;
            }
        }

        if (find) {
            // M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다.
            System.out.println(sum);
            System.out.println(min);
        } else {
            // 단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
            System.out.println(-1);
        }

        // System.out.println("end: " + (System.currentTimeMillis() - start));
    }

    public static boolean isPrimeNumber(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
