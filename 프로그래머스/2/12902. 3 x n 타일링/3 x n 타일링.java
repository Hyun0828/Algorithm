import java.util.*;

class Solution {
    public int solution(int n) {
        if(n % 2 == 1)
            return 0;
        
        // f(n) = f(n-2) x 4 - f(n-4)
        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 3;
        int md = 1000000007;
        
        for(int i=4; i<=n; i+=2){
            dp[i] = (dp[i-2] * 4 % md - dp[i-4] % md + md) % md;
        }
        
        return (int)dp[n];
    }
}