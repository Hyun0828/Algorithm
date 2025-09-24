import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        return binarySearch(times, n);
    }
    
    public boolean check(int[] times, int n, long ctime) {
        long answer = 0;
        for(int time : times){
            answer += ctime / time;
        }
        return answer >= n;
    }
    
    public long binarySearch(int[] times, int n) {
        long answer = 0;
        long start = 1L;
        long end = 1_000_000_000L * 1_000_000_000L;
        
        while(start <= end){
            long mid = (start + end) / 2;
            
            if(check(times, n, mid)){
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}