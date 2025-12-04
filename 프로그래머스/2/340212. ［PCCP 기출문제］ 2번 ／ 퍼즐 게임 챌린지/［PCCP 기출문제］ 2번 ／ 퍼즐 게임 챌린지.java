import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int start = 1;
        int end = 100000;
        
        while(start <= end){
            int mid = (start + end) / 2;
            if(check(diffs, times, mid, limit)){
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
    
    public boolean check(int[] diffs, int[] times, int level, long limit){
        long sum = (long) times[0];
        for(int i=1; i<diffs.length; i++){
            if(diffs[i] <= level){
                sum += times[i];
            } else {
                sum += (diffs[i] - level) * (times[i] + times[i-1]);
                sum += times[i];
            }
        }
        
        if(sum <= limit)
            return true;
        return false;
    }
}