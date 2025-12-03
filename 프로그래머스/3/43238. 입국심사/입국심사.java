import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long start = 0;
        long end = 1000000000L * 1000000000L;
        while(start <= end){
            long mid = (start + end) / 2;
            if(check(mid, n, times)){
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean check(long mid, int n, int[] times){
        long sum = 0;
        for(int i=0; i<times.length; i++){
            sum += mid / (long) times[i];
        }
        if(sum >= n)
            return true;
        return false;
    }
}