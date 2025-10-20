import java.util.*;

class Solution{
    public int solution(int[][] board){
        // int[][] dp = new int[board.length][board[0].length];
        // for(int i=0; i<board[0].length; i++)
        //     dp[0][i] = board[0][i];
        // for(int i=0; i<board.length; i++)
        //     dp[i][0] = board[i][0];
        
        for(int i=1; i<board.length; i++){
            for(int j=1; j<board[i].length; j++){
                if(board[i][j] == 0){
                    continue;
                }
                // board[i][j] == 1
                // 0이 하나라도 있으면 1이다.
                if(board[i-1][j-1] == 0 || board[i][j-1] == 0 || board[i-1][j] == 0)
                    board[i][j] = 1;
                // 0이 없는데 전부 같으면 n+1이다
                else if(board[i-1][j-1] == board[i-1][j] && board[i-1][j-1] == board[i][j-1])
                    board[i][j] = board[i-1][j-1] + 1;
                // 0이 없는데 전부 같진 않으면 최솟값 + 1이다
                else {
                    int n = Math.min(board[i-1][j-1], Math.min(board[i][j-1], board[i-1][j]));
                    board[i][j] = n + 1;
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                answer = Math.max(answer, board[i][j]);
            }
        }
        return answer * answer;
    }
}