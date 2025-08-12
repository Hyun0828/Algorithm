import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i);

        int[] answer = new int[n];
        k--; 

        for (int i = 0; i < n; i++) {
            long fact = factorial(n - i - 1);
            int idx = (int) (k / fact);
            answer[i] = nums.get(idx);
            nums.remove(idx);
            k %= fact;
        }
        return answer;
    }
    
    public static long factorial(int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}