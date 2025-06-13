package week08;

import java.util.*;
import java.io.*;
public class 프로그래머스_2_수식최대화_김해린 {
    static boolean[] visited;
    static String[] operator;
    static List<String> list = new ArrayList<>();
    static long max = Long.MIN_VALUE;

    public long solution(String expression) {
        HashSet<String> opSet = new HashSet<>();
        list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                opSet.add(expression.substring(i, i + 1));
                list.add(expression.substring(start, i));
                list.add(expression.substring(i, i + 1));
                start = i + 1;
            } else if (i == expression.length() - 1) {
                list.add(expression.substring(start, i + 1));
            }
        }

        String[] arr = new String[opSet.size()];
        int idx = 0;
        visited = new boolean[opSet.size()];
        operator = new String[opSet.size()];
        for (String string : opSet) {
            arr[idx++] = string;
        }
        dfs(0, arr);


        return max;
    }

    private static void dfs(int depth, String[] arr) {
        if (arr.length == depth) {
            List<String> copyList = new ArrayList<>(list);
            max = Math.max(max, Math.abs(cal(copyList)));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                operator[depth] = arr[i];
                dfs(depth + 1, arr);
                visited[i] = false;
            }
        }
    }

    private static long cal(List<String> copyList) {
        for (int i = 0; i < operator.length; i++) {
            int idx = 0;
            while (idx != copyList.size()) {
                if (operator[i].equals(copyList.get(idx))) {
                    long num = 0;
                    if (operator[i].equals("*")) {
                        num = Long.parseLong(copyList.get(idx - 1)) * Long.parseLong(copyList.get(idx + 1));
                    } else if (operator[i].equals("-")) {
                        num = Long.parseLong(copyList.get(idx - 1)) - Long.parseLong(copyList.get(idx + 1));
                    } else if (operator[i].equals("+")) {
                        num = Long.parseLong(copyList.get(idx - 1)) + Long.parseLong(copyList.get(idx + 1));
                    }
                    copyList.set(idx - 1, String.valueOf(num));
                    copyList.remove(idx);
                    copyList.remove(idx);
                } else idx++;
            }
        }

        return Long.parseLong(copyList.get(0));
    }
}
