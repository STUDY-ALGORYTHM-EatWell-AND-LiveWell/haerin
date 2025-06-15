package week10;

import java.io.*;
import java.util.*;
//현재까지 방문한 모든 노드의 자식 중에서 자유롭게 다음 노드를 선택할 수 있어야 한다!!
public class 프로그래머스_3_양과늑대_김해린 {
    int max = 0;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public int solution(int[] info, int[][] edges) {
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 0, 0, list, info);
        return max;
    }

    void dfs(int idx, int sheep, int wolf, List<Integer> nextNodes, int[] info) {
        if (info[idx] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        if (sheep <= wolf) {
            return;
        }
        max = Math.max(sheep, max);

        List<Integer> list = new ArrayList<>(nextNodes);
        list.remove(Integer.valueOf(idx)); //현재 방문한 노드 제거
        list.addAll(graph.get(idx)); //현재 노드의 자식 노드를 추가

        for (Integer i : list) {
            dfs(i, sheep, wolf, list, info);
        }
    }
}


