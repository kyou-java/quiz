package com.quiz.solution.acm_icpc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem14888 {

    public static void main(String[] args) {
        // 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.
        Scanner sc = new Scanner(System.in);

        // 첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다.
        int count = sc.nextInt();
        int[] number = new int[count];
        int[] operator = new int[4];

        // 둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100)
        for (int i = 0; i < count; i++) {
            number[i] = sc.nextInt();
        }

        // 셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데,
        // 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        solve(number, operator);
    }

    public static void solve(int[] number, int[] operator) {
        String[] o = getOperator(operator);
        HashSet<String> set = new HashSet<>();

        permutation(set, "", String.join("", o));

        int[] result = new int[set.size()];

        int count = 0;
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            StringBuilder sb = new StringBuilder();
            String s = iterator.next();

            for (int i = 0; i < number.length; i++) {
                if (i < number.length - 1) {
                    sb.append(number[i]).append(s.charAt(i));
                } else {
                    sb.append(number[i]);
                }
            }

            result[count] = operate(sb.toString());
            count++;
        }

        Arrays.sort(result);

        System.out.println(result[set.size() - 1]);
        System.out.println(result[0]);
    }

    public static String[] getOperator(int[] operator) {
        int sum = Arrays.stream(operator).sum();
        String[] result = new String[sum];

        int point = 0;
        for (int i = 0; i < operator.length; i++) {
            for (int j = 0; j < operator[i]; j++) {
                switch (i) {
                    case 0:
                        result[point] = "+";
                        break;
                    case 1:
                        result[point] = "-";
                        break;
                    case 2:
                        result[point] = "*";
                        break;
                    case 3:
                        result[point] = "/";
                        break;
                }

                point++;
            }
        }

        return result;
    }

    // 모든 경우의 수를 구하는 순열
    public static void permutation(Set<String> set, String prefix, String s) {
        int n = s.length();

        if (n == 0) {
            set.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(set, prefix + s.charAt(i),
                    s.substring(0, i) + s.substring(i + 1));
            }
        }
    }

    // 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다.
    public static int operate(String input) {
        int result = 0;

        String token;
        StringTokenizer tokenizer = new StringTokenizer(input, "+-*/", true);

        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();

            switch (token) {
                case "+":
                    token = tokenizer.nextToken();
                    result += Integer.parseInt(token);
                    break;
                case "-":
                    token = tokenizer.nextToken();
                    result -= Integer.parseInt(token);
                    break;
                case "*":
                    token = tokenizer.nextToken();
                    result *= Integer.parseInt(token);
                    break;
                case "/":
                    token = tokenizer.nextToken();
                    result /= Integer.parseInt(token);
                    break;
                default:
                    result = Integer.parseInt(token);
            }
        }

        return result;
    }
}
