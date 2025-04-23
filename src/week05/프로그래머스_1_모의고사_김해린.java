package week05;

import java.io.*;
import java.util.*;
public class 프로그래머스_1_모의고사_김해린 {
    public int[] solution(int[] answers) {

        int s1[] = {1, 2, 3, 4, 5};
        int s2[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int s3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];


        for (int i = 0; i < answers.length; i++) {
            if (s1[i % s1.length] == answers[i]) {
                score[0]++;
            }
            if (s2[i % s2.length] == answers[i]) {
                score[1]++;
            }
            if (s3[i % s3.length] == answers[i]) {
                score[2]++;
            }
        }

        int tmp[] = Arrays.copyOf(score, 3);
        Arrays.sort(tmp);
        int max = tmp[2];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                list.add(i + 1);
            }
        }
        int answer[] = new int[list.size()];
        int idx = 0;
        for (int i : list) {
            answer[idx++] = i;
        }
//        Arrays.sort(answer);

        return answer;
    }
}
