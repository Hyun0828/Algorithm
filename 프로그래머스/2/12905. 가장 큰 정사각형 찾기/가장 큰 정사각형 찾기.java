import java.util.*;

class Solution{
    public int solution(int [][]board){
        int Y = board.length;
        int X = board[0].length;
        int[][] dp = new int[Y][X];
        
        for(int i=0; i<X; i++){
            dp[0][i] = board[0][i];
        }
        for(int i=0; i<Y; i++){
            dp[i][0] = board[i][0];
        }
        
        for(int i=1; i<Y; i++){
            for(int j=1; j<X; j++){
                if(board[i][j] == 1)
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
            }
        }
        
        int max = 0;
        for(int i=0; i<Y; i++){
            for(int j=0; j<X; j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max * max;
    }
}