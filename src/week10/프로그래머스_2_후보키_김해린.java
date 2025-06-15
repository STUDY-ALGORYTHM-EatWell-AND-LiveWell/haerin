package week10;

import java.util.*;
import java.io.*;
public class 프로그래머스_2_후보키_김해린 {
    ArrayList<String> answer = new ArrayList<>();
    public int solution(String[][] relation) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(0, list, relation);
        return answer.size();
    }

    void dfs(int start, ArrayList<Integer> list, String[][] relation) {
        isKey(list, relation);
        if (start == relation[0].length) {
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            list.add(i);
            dfs(i + 1, list, relation);
            list.remove(list.size() - 1);
        }
    }



    void isKey(ArrayList<Integer> list, String[][] relation) {
        String key = "";
        for (Integer i : list) {
            key += String.valueOf(i);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            String str = "";
            for (Integer j : list) {
                str += relation[i][j];
            }
            if (set.contains(str)) return;
            set.add(str);
        }

        for (String s : answer) {
            int cnt = 0;
            for (char ch : key.toCharArray()) {
                if (s.contains(String.valueOf(ch))) {
                    cnt++;
                }
            }

            if (cnt == s.length()) {
                return;
            }
        }

        answer.add(key);
    }
}
