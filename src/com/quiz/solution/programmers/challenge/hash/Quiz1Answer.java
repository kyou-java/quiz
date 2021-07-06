package com.quiz.solution.programmers.challenge.hash;

import java.util.HashMap;
import java.util.Map;

public class Quiz1Answer {

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solve(participant, completion));
    }

    public static String solve(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> result = new HashMap<>();

        for (String p : participant) {
            result.put(p, result.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            result.put(c, result.get(c) - 1);
        }

        for (String key : result.keySet()) {
            if (result.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
