import java.util.*;

class Solution {
    
    int answer = 0;
    public int solution(int n) {
        dfs(new int[n], 0, n);
        return answer;
    }
    
    public boolean isOk(int[] queens, int row, int col, int n){
        for(int i=0; i<row; i++){
            int r = i;
            int c = queens[i];
            
            if(c == col)
                return false;
            
            if(Math.abs(r-row) == Math.abs(c-col))
                return false;
        }
        return true;
    }
    
    public void dfs(int[] queens, int row, int n){
        if(row == n){
            answer++;
            return;
        }
        
        for(int i=0; i<n; i++){
            // (row, i)에 퀸을 둘 수 있다면
            if(isOk(queens, row, i, n)){
                queens[row] = i;
                dfs(queens, row + 1, n);
            }
        }
    }
}