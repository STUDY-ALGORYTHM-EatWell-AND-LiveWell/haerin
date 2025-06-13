package week08;

import java.util.*;
import java.io.*;
public class 프로그래머스_1_신고결과받기_김해린 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> map = new HashMap<>(); //report 정보를 담음
        HashMap<String, Integer> idx = new HashMap<>(); //id의 인덱스 정보를 담음

        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            idx.put(id_list[i], i);
        }

        for (int i = 0; i < report.length; i++) {
            String[] tmp = report[i].split(" "); //신고자 -> 피신고인
            map.get(tmp[1]).add(tmp[0]); //피신고인 Key 값에 중복되지않은 신고자 이름이 Value로 들어감
        }

        //따라서 Hashset 길이가 신고당한 횟수
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> set = map.get(id_list[i]);
            if (set.size() >= k) {
                for (String name : set) {
                    answer[idx.get(name)]++;
                }
            }
        }

        return answer;
    }
}
