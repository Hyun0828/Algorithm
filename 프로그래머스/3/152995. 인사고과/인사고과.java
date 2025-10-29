import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] wanho = scores[0];
        
        Arrays.sort(scores, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            } else{
                return b[0] - a[0];
            }
        });
        
        int maxSecond = scores[0][1];
        for(int i=0; i<scores.length; i++){
            if(maxSecond > scores[i][1]){
                if(scores[i][0] == wanho[0] && scores[i][1] == wanho[1])
                    return -1;
                continue;
            }
            if(scores[i][0] + scores[i][1] > wanho[0] + wanho[1])
                answer++;
            maxSecond = Math.max(maxSecond, scores[i][1]);
        }
        
        return answer;
    }
}