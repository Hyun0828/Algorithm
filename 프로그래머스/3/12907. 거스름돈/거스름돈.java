import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
      
        // dp[0] dp[1] dp[2] dp[3] dp[4] dp[5]
        //   1     1     1     1     1     1
        //   1     1     2     2     3     3
        //   1     1     
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=0; i<money.length; i++){
            for(int j=money[i]; j<n+1; j++){
                dp[j] += dp[j - money[i]];
            }
        }
        
        return dp[n];
    }
}