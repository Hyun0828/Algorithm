import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int len = arr.length;
        solve(answer, arr, len, 0, 0);
        return answer;
    }
    
    public void solve(int[] answer, int[][] arr, int len, int y, int x){
        int n = arr[y][x];
        boolean isSame = true;
        for(int i=y; i<y+len; i++){
            for(int j=x; j<x+len; j++){
                if(n != arr[i][j]){
                    isSame = false;
                    break;
                }
            }
            if(!isSame)
                break;
        }
        
        if(isSame){
            answer[n]++;
            return;
        }
        
        solve(answer, arr, len/2, y, x);
        solve(answer, arr, len/2, y+len/2, x);
        solve(answer, arr, len/2, y, x+len/2);
        solve(answer, arr, len/2, y+len/2, x+len/2);
    }
}