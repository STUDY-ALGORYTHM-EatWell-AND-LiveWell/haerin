package week05;

import java.util.*;
import java.io.*;

public class 프로그래머스_3_경주로건설 {
    static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4]; // 방향별 비용 저장

        for (int[][] row : cost)
            for (int[] c : row)
                Arrays.fill(c, Integer.MAX_VALUE);

        Queue<Spot> q = new LinkedList<>();

        // 시작지점에서 우, 하 방향 출발
        q.add(new Spot(0, 0, -1, 0));

        while (!q.isEmpty()) {
            Spot now = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[ny][nx] == 0) {
                    int newCost = now.cost + ((now.dir == -1 || now.dir == dir) ? 100 : 600);

                    if (cost[ny][nx][dir] > newCost) {
                        cost[ny][nx][dir] = newCost;
                        q.add(new Spot(nx, ny, dir, newCost));
                    }
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minCost = Math.min(minCost, cost[n - 1][n - 1][i]);
        }

        return minCost;
    }

    static class Spot {
        int x, y, dir, cost;

        public Spot(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}
