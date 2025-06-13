package week10;

import java.io.*;
import java.util.*;

public class 프로그래머스_1_문자열압축_김해린 {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String str = s.substring(0, i);
            int cnt = 1;
            for (int j = i; j <= s.length(); j += i) {
                int endIdx = Math.min(j + i, s.length());
                String tmp = s.substring(j, endIdx);
                if (str.equals(tmp)) {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        sb.append(cnt);
                    }
                    sb.append(str);
                    str = tmp;
                    cnt = 1;
                }
            }
            sb.append(str);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
