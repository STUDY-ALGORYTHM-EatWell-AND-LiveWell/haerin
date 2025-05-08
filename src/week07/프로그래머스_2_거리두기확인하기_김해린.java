package week07;

import java.util.*;
import java.io.*;
public class 프로그래머스_2_거리두기확인하기_김해린 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = isCorrect(places[i]);
        }
        return answer;
    }

    public static int isCorrect(String[] place) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (place[y].charAt(x) == 'P' && !bfs(x, y, place)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static boolean bfs(int x, int y, String[] place) {
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y));
        boolean[][] visited = new boolean[5][5];
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node cur = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int distance = Math.abs(nx - x) + Math.abs(ny - y);

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || distance > 2 || visited[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = true;

                if (place[ny].charAt(nx) == 'X') continue;
                else if (place[ny].charAt(nx) == 'P') return false;
                else q.add(new Node(nx, ny));
            }
        }
        return true;
    }
}

class Node {
    int x, y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
