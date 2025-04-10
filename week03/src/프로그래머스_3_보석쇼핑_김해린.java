import java.awt.*;
import java.util.*;

public class 프로그래머스_3_보석쇼핑_김해린 {
    public int[] solution(String[] gems) {
        HashSet<String> h1 = new HashSet<>(Arrays.asList(gems));
        int size = h1.size();
        int[] answer = new int[2];
        int end_idx = 0, start_idx = 0;
        int min = gems.length + 1;
        Map<String, Integer> map = new HashMap<>();
        for (; end_idx < gems.length; end_idx++) {
            map.put(gems[end_idx], map.getOrDefault(gems[end_idx], 0) + 1);

            while (map.get(gems[start_idx]) > 1) {
                map.put(gems[start_idx], map.get(gems[start_idx]) - 1);
                start_idx++;
            }

            if (map.size() == size && min > end_idx - start_idx + 1) {
                min = end_idx - start_idx + 1;
                answer[1] = end_idx + 1;
                answer[0] = start_idx + 1;
            }
        }
        return answer;
    }

    public int[] wrongSolution(String[] gems){
        HashSet<String> h1 = new HashSet<>();
        Collections.addAll(h1, gems);

        int size = h1.size();
        int min = gems.length;
        int[] answer = new int[2];

        for (int i = 0; i < gems.length; i++) {
            HashSet<String> h2 = new HashSet<>();
            int end_idx = i;
            for (; end_idx < gems.length; end_idx++) {
                h2.add(gems[end_idx]);
                if(h2.size() == size){
                    break;
                }
            }
            if (end_idx == 8) end_idx--;
            if (h2.size() == size) {
                if (min > h2.size()) {
                    min = h2.size();
                    answer[0] = i + 1;
                    answer[1] = end_idx + 1;
                }
            }
        }

        return answer;
    }
}
