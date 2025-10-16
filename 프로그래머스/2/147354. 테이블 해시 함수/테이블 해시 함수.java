import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // 1. col, pk 기준으로 정렬한다.
        Arrays.sort(data, (a,b) -> {
            if(a[col-1] == b[col-1]){
                return b[0] - a[0];
            } else {
                return a[col-1] - b[col-1];
            }
        });
            
        // 2. row_begin ~ row_end 튜플에 대해 S 값을 계산한다.
        int[] arr = new int[row_end-row_begin+1];
        for(int i=row_begin-1; i<=row_end-1; i++){
            int sum = 0;
            for(int j=0; j<data[i].length; j++){
                sum += data[i][j] % (i + 1);
            }
            arr[i-row_begin+1] = sum;
        }    
        
        // 3. XOR 
        answer = arr[0];
        for(int i=1; i<arr.length; i++){
            answer = answer ^ arr[i];
        }
        
        return answer;
    }
}