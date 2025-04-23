package week05;

import java.util.*;
import java.io.*;
public class 프로그래머스_2_소수찾기_김해린 {
    static char num[];
    static HashSet<Integer> set = new HashSet<>();
    static boolean visited[] = new boolean[7];
    public int solution(String numbers) {
        int answer = 0;

        BT(numbers, "", 0);
        for (int i : set) {
            if (!isPrime(i)) {
                answer++;
            }
        }
        return answer;
    }

    static void BT(String numbers, String str, int depth) {
        if (depth == numbers.length()) {
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(str + numbers.charAt(i)));
                BT(numbers, str + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return true;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
}
