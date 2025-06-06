package week09;

import java.util.*;
import java.io.*;
public class 프로그래머스_1_가장많이받은선물_김해린 {
    public int solution(String[] friends, String[] gifts) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        int[][] giftGraph = new int[friends.length][friends.length];
        int[] giftNum = new int[friends.length];

        for (String gift : gifts) {
            String[] tmp = gift.split(" ");
            String from = tmp[0];
            String to = tmp[1];


            giftGraph[map.get(from)][map.get(to)]++;
            giftNum[map.get(from)]++;
            giftNum[map.get(to)]--;
        }


        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < friends.length; i++) {
            int x = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                if (giftGraph[i][j] > giftGraph[j][i]) {
                    x++;
                } else if (giftGraph[i][j] == giftGraph[j][i] && giftNum[i] > giftNum[j]) {
                    x++;
                }
            }
            answer = Math.max(x, answer);
        }

        return answer;
    }
}
