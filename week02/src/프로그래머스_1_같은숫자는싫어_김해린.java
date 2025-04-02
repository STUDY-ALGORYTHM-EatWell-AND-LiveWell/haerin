import java.util.Arrays;
import java.util.Stack;

public class 프로그래머스_1_같은숫자는싫어_김해린 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
    }

    public static int[] solution(int[] arr) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (s.empty()) s.push(arr[i]);
            else if (s.peek() != arr[i]) s.push(arr[i]);
        }
        int answer[] = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            answer[i] = s.pop();
        }
        return answer;
    }
}
