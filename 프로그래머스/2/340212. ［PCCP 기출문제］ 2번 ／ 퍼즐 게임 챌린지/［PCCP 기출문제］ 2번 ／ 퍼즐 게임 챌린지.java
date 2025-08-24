import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int start = 1;
        int end = 100000;
    
        while(start <= end){
            int mid = (start + end) / 2;
            
            // f가 true면 저장하고 왼쪽으로, false면 그냥 오른쪽으로
            if(f(diffs, times, limit, mid)){
                answer = mid;
                end =  mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean f(int[] diffs, int[] times, long limit, int level){
        long temp = 0 ;
        for(int i=0; i<diffs.length; i++){
            if(diffs[i] <= level){
                temp += times[i];
            } else {
                temp += (times[i-1] + times[i]) * (long) (diffs[i] - level);
                temp += times[i];
            }
        
        }
        
        if(limit < temp)
            return false;
        return true;
    }
}