import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, (a,b) -> Integer.compare(a[1], b[1]));
        
        int e = targets[0][1];
        for(int i=1; i<targets.length; i++){
            int s = targets[i][0];
            
            if(s >= e){
                e = targets[i][1];
                answer++;
            }
        }
        
        
        return answer;
    }
}