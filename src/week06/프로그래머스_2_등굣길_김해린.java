package week06;

import java.io.*;
import java.util.*;
public class 프로그래머스_2_등굣길_김해린 {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int dp[][] = new int[n][m];

        for (int puddle[] : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i > 0) dp[i][j] = (dp[i - 1][j] + dp[i][j]) % MOD;
                if (j > 0) dp[i][j] = (dp[i][j - 1] + dp[i][j]) % MOD;
            }
        }
        return dp[n - 1][m - 1];
    }
}
