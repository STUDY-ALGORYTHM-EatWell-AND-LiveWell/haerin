package week06;

import java.util.*;
import java.io.*;

public class 프로그래머스_1_정수삼각형_김해린 {
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == i) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
                }
                answer = Math.max(triangle[i][j], answer);
            }
        }

        return answer;
    }
}
