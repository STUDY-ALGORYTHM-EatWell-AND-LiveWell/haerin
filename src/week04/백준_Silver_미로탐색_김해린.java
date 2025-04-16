package week04;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_Silver_미로탐색_김해린 {
    static int N, M;
    static int arr[][];
    static boolean[][] visited;
    static int moveX[] = {0, 0, 1, -1};
    static int moveY[] = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        int distance[][] = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            int idx = 0;
            String str = br.readLine();
            for (char ch : str.toCharArray()) {
                arr[i][idx++] = ch - '0';
            }
        }

        visited[0][0] = true;
        distance[0][0] = 1;

        bfs(0, 0);
        System.out.println(arr[N - 1][M - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<spot> q = new LinkedList<>();
        q.add(new spot(x, y));

        while (!q.isEmpty()) {
            spot s = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = s.x + moveX[i];
                int nextY = s.y + moveY[i];


                if (nextY < 0 || nextX < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (arr[nextX][nextY] == 0 || visited[nextX][nextY]) {
                    continue;
                }
                q.add(new spot(nextX, nextY));
                arr[nextX][nextY] = arr[s.x][s.y] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }

    static class spot {
        int x, y;
        spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
