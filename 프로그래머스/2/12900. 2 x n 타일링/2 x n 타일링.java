import java.util.*;

class Solution {
    public int solution(int n) {
        int N = 1000000007;
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++){
            dp[i] = ((dp[i-1]%N) + (dp[i-2]%N))%N;
        }
        
        return dp[n];
    }
}