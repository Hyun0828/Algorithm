import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        List<Integer> nums = new ArrayList<>();
        for(int i=1; i<=n; i++)
            nums.add(i);
        int[] answer = new int[n];
        k--;
        
        for(int i=0; i<n; i++){
            long f = factorial(n - i - 1);
            int idx = (int) (k / f);
            answer[i] = nums.get(idx);
            nums.remove(idx);
            k %= f;
        }
        
        return answer;
    }
    
    public long factorial(int n){
        if(n==0 || n==1)
            return 1;
        return factorial(n-1) * n;
    }
}