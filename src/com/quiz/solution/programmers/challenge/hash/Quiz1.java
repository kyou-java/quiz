package com.quiz.solution.programmers.challenge.hash;

import java.util.Arrays;

public class Quiz1 {

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;

        for (i = 0; i < participant.length; i++) {
            if (!participant[i].equals(completion[i])) {
                break;
            }
        }

        System.out.println(participant[i]);
    }
}
