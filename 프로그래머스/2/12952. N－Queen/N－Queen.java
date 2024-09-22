class Solution {
    
    int answer = 0;
    int[] queen = new int[12];
    
    public int solution(int n) {
        
        backTracking(0, n);
        return answer;
    }
    
    private boolean check(int row, int col, int n){
        
        for(int i=0;i<row;i++){
            
            // 같은 열인지
            if(queen[i] == col)
                return false;
            
            // 오른쪽 대각선
            if(Math.abs(queen[i]-i+n) == Math.abs(col-row+n))
                return false;
            // 왼쪽 대각선
            if(Math.abs(queen[i]+i) == Math.abs(col+row))
                return false;
            
            // if (Math.abs(queen[i] - col) == Math.abs(i - row)) 
            //     return false;   
        }
        
        return true;
    }
    
    private void backTracking(int row, int n){
        
        if(row==n){
            answer++;
            return;
        }
        
        for(int i=0; i<n; i++){
            if(check(row, i, n)){
                queen[row] = i;   
                backTracking(row+1, n);
            }
        }
    }
}