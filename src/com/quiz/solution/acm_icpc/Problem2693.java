package com.quiz.solution.acm_icpc;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2693 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int count = sc.nextInt();
    int[][] input = new int[count][10];

    for (int i = 0; i < count; i++) {
      for (int j = 0; j < 10; j++) {
        input[i][j] = sc.nextInt();
      }

      Arrays.sort(input[i]);
    }

    solve(input);
  }

  public static void solve(int[][] input) {
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        if (j == input[i].length - 3) {
          System.out.println(input[i][j]);
        }
      }
    }
  }
}
