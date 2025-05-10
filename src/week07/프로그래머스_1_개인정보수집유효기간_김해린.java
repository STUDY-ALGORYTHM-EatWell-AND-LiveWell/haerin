package week07;

import java.util.*;
import java.io.*;
public class 프로그래머스_1_개인정보수집유효기간_김해린 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int cur = calculateDate(today);
        Map<String, Integer> map = new HashMap<>();
        for (String str : terms) {
            String[] term = str.split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int day = calculateDate(privacy[0]);
            day += (map.get(privacy[1]) * 28);
            if (day <= cur) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static int calculateDate(String str) {
        StringTokenizer st = new StringTokenizer(str, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        return year * 12 * 28 + month * 28 + day;
    }
}
