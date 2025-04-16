package week04;

import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_1_네트워크_김해린 {
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(n, computers, i);
            }
        }
        return answer;
    }

    public static void dfs(int n, int[][] computers, int node) {
        for (int i = 0; i < n; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(n, computers, i);
            }
        }
    }

    public static void bfs(int n, int[][] computers, int node) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            node = q.poll();
            for (int i = 0; i < n; i++) {
                if (computers[node][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
