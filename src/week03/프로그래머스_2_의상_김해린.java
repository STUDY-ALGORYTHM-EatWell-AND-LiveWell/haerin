package week03;

import java.util.HashMap;

public class 프로그래머스_2_의상_김해린 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1], 0) + 1);
        }
        int answer = 1;

        for (String key : hash.keySet()) {
            int value = hash.get(key) + 1;
            answer *= value;
        }
        return answer - 1;
    }
}

