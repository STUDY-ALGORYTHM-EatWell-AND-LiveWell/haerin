package week03;

import java.util.HashSet;

public class 프로그래머스_1_폰켓몬_김해린 {
    public int solution(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }
        int max = nums.length / 2;
        return Math.min(max, hash.size());
    }
}
