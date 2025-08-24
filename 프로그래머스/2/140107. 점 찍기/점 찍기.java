import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long x;
        long y;
        long r = (long) Math.pow(d, 2);
        
        for(x=0; x<=d; x+=k){
            y = (long) Math.sqrt(r - (long) Math.pow(x,2));
            
            answer += y / (long) k + 1;
        }
        
        return answer;
    }
}