package week04;

import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_2_게임맵최단거리_김해린 {
    static int moveX[] = {0, 0, -1, 1};
    static int moveY[] = {-1, 1, 0, 0};
    static int N, M;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        int distance[][] = new int[N][M];
        bfs(maps, distance);
        if (distance[N - 1][M - 1] == 0) {
            return -1;
        } else {
            return distance[N - 1][M - 1];
        }
    }

    public static void bfs(int[][] maps, int[][] distance) {
        distance[0][0] = 1;
        Queue<spot> q = new LinkedList<>();
        int x = 0, y = 0;
        q.add(new spot(x, y));
        while (!q.isEmpty()) {
            spot s = q.poll();
            x = s.x;
            y = s.y;
            for (int i = 0; i < 4; i++) {
                int nextX = x + moveX[i];
                int nextY = y + moveY[i];

                if (nextX < N && nextX >= 0 && nextY < M && nextY >= 0 && distance[nextX][nextY] == 0 && maps[nextX][nextY] == 1) {
                    distance[nextX][nextY] = distance[x][y] + 1;
                    q.add(new spot(nextX, nextY));
                }
            }

        }
    }
}

class spot {
    int x, y;

    public spot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
