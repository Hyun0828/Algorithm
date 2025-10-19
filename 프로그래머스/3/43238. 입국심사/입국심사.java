import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // 특정 시간 이하면 심사를 받을 수 없고, 특정 시간 이상이면 무조건 심사가 가능하다.
        // parametric search !
        
        long start = 0;
        long end = 1000000000L * 1000000000L;
        while(start <= end){
            long mid = (start + end) / 2;
            if(check(n, times, mid)){
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean check(int n, int[] times, long time){
        long num = 0;
        for(int i=0; i<times.length; i++){
            num += time / (long) times[i];
        }
        if(num >= n)
            return true;
        return false;
    }
}