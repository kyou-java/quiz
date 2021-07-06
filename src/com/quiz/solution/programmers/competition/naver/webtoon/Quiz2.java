package com.quiz.solution.programmers.competition.naver.webtoon;

import java.util.Arrays;

public class Quiz2 {

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(Arrays.toString(getAnswer(arg)));
        }
    }

    public static String[] getAnswer(String s) {
        System.out.println("input: " + s);

        String[] answer = {};

        int half = s.length() / 2;
        int matchCnt = 0;

        int beginIndex = 0;
        int endIndex = s.length();
        int length = 1;

        for (int i = 0; i < half; i++) {
            // System.out.println("beginIndex: " + beginIndex + ", endIndex: " + endIndex + ", length: " + length);

            String b = s.substring(beginIndex, beginIndex + length);
            String e = s.substring(endIndex - length, endIndex);

            // System.out.println(b + ", " + e);

            if (b.equals(e)) {
                matchCnt++;

                // System.out.println(">> Match: " + b);
                answer = expand(answer, b, true);
                s = s.substring(beginIndex + length, endIndex - length);
                // System.out.println(">> After match: " + s);

                // Reset
                length = 1;
                beginIndex = 0;
                endIndex = s.length();
            } else {
                length++;
            }
        }

        if (!s.isEmpty()) {
            answer = expand(answer, s, false);
        }

        return answer;
    }

    public static String[] expand(String[] origin, String value, boolean twice) {
        String[] result = new String[origin.length + (twice ? 2 : 1)];
        int half = origin.length / 2;

        for (int i = 0; i < result.length; i++) {
            if (i < half) {
                result[i] = origin[i];
            } else if (i == half || (twice && i == half + 1)) {
                result[i] = value;
            } else {
                result[i] = origin[i - (twice ? 2 : 1)];
            }
        }

        return result;
    }
}
