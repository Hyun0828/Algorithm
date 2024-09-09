import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        if(arr.length == 1)
            answer = new int[]{-1};
        else{
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for(int i=0; i<arr.length; i++){
                if(min >= arr[i]){
                    min = arr[i];
                    idx = i;
                }
            }
            
            for(int i=idx; i<arr.length-1; i++){
                arr[i] = arr[i+1];
            }
            
            answer = new int[arr.length-1];
            for(int i=0; i<arr.length-1; i++){
                answer[i] = arr[i];
            }
        }
        
        return answer;
    }
}