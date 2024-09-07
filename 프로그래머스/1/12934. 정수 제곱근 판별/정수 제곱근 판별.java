import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        Double root = Math.sqrt(n);
        if(root == root.intValue())
            answer = (long)Math.pow(root+1, 2);
        else
            answer = -1;
        
        return answer;
    }
}