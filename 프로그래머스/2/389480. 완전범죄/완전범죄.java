import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        
        int[][] dp = new int[info.length+1][m];
        for(int i=0; i<=info.length; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = 1000000;
            }
        }
        
        dp[0][0] = 0;
        for(int i=1; i<=info.length; i++){
            int a = info[i-1][0];
            int b = info[i-1][1];
            
            for(int j=0; j<m; j++){
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a); // i번째 물건을 A가 훔친다.
                if(j+b < m)
                    dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]); // i번째 물건을 B가 훔친다.
            }
        }
        
        int min = 1000000;
        for(int i=0; i<m; i++){
            min = Math.min(dp[info.length][i], min);
        }
        
        return min >= n ? -1 : min;
    }
}