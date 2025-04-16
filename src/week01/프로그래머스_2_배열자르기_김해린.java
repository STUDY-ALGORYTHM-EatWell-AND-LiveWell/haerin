package week01;

import java.util.Arrays;

public class 프로그래머스_2_배열자르기_김해린 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5)));

    }

    public static int[] solution(int n, long left, long right) {
        int len = (int) right - (int) left + 1;
        int[] answer = new int[len];
        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n + 1;
            long col = i % n + 1;
            answer[idx++] = Math.max((int) row, (int) col);
        }
        return answer;
    }
}