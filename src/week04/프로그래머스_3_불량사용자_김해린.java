package week04;

import java.util.HashSet;
import java.util.Set;

public class 프로그래머스_3_불량사용자_김해린 {
    static String[] user_id, banned_id;
    static boolean[] visited;
    static Set<Set<String>> result = new    HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        visited = new boolean[banned_id.length];
        dfs(0, new HashSet<>());

        return result.size();

    }

    public static void dfs(int idx, Set<String> set) {
        if (set.size() == banned_id.length) {
            result.add(set);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (set.contains(user_id[i])) continue;
            if (isMatch(user_id[i], banned_id[idx])) {
                set.add(user_id[i]);
                dfs(idx + 1, new HashSet<>(set));
                set.remove(user_id[i]);
            }
        }
    }

    public static boolean isMatch(String id, String banned_id) {
        if (id.length() != banned_id.length()) return false;
        for (int i = 0; i < id.length(); i++) {
            if (banned_id.charAt(i)=='*') continue;
            if (banned_id.charAt(i) != id.charAt(i)) return false;
        }

        return true;
    }
}
