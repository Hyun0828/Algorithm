import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> arr = new ArrayList<>();
        
        // (i,j) <-> i * n + j
        int left_i = (int)(left/n);
        int left_j = (int)(left%n);
        int right_i = (int)(right/n);
        int right_j = (int)(right%n);
        
        if(left_i != right_i){
            for(int j=left_j; j<n; j++){
            int value = Math.max(left_i+1, j+1);
            arr.add(value);
        }
            for(int i=left_i+1; i<right_i; i++){
                for(int j=0; j<n; j++){
                    int value = Math.max(i+1, j+1);
                    arr.add(value);
                }
            }
            for(int j=0; j<=right_j; j++){
                int value = Math.max(right_i+1, j+1);
                arr.add(value);
            }  
        } else {
            for(int j=left_j; j<=right_j; j++){
                int value = Math.max(left_i+1, j+1);
                arr.add(value);
            }
        }
        
            
        return arr.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}