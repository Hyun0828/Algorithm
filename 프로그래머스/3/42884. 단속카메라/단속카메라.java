import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        
        int idx = routes[0][1];
        answer++;
        
        for(int i=1; i<routes.length; i++) {
            if(idx < routes[i][0]) {
                idx = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}