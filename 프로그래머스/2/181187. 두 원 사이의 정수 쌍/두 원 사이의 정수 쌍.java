import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 4 * (r2 - r1 + 1);
        
        for(int x=1; x<r2; x++){
            long smallY = (long)Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(x,2)));
            long bigY = (long)Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(x,2)));
            if(smallY == 0)
                smallY = 1;
            // System.out.println(smallY + ", " + bigY);
            answer += 4 * (bigY - smallY + 1);
        }
        
        return answer;
    }
}