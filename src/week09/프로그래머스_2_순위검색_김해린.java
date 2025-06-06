package week09;

import java.util.*;
import java.io.*;

public class 프로그래머스_2_순위검색_김해린 {
    static HashMap<String, ArrayList<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for (String string : info) {
            String[] arr = string.split(" ");
            dfs(0, "", arr);
        }

        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
        }

        int[] answer = new int[query.length];
        int idx = 0;

        for (String string : query) {
            String[] str = string.replaceAll(" and ", "").split(" ");
            if (map.containsKey(str[0])) {
                ArrayList<Integer> list = map.get(str[0]);
                answer[idx++] = binarySearch(list, Integer.parseInt(str[1]));
            } else {
                answer[idx++] = 0;
            }
        }
        return answer;
    }

    private static int binarySearch(ArrayList<Integer> list, int score) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < score) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return list.size() - left;
    }

    private static void dfs(int depth, String str, String[] arr) {
        if (depth == 4) {
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(Integer.parseInt(arr[4]));
            return;
        }

        dfs(depth + 1, str + arr[depth], arr);
        dfs(depth + 1, str + "-", arr);
    }
}
