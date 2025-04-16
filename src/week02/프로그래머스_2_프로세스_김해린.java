package week02;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프로그래머스_2_프로세스_김해린 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int v : priorities) {
            q.offer(v);
        }
        int answer = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (q.peek() == priorities[i]) {
                    q.poll();
                    answer++;
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
