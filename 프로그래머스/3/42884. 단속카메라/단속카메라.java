import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        int cam = routes[0][1];
        
        for(int i=1; i<routes.length; i++){
            if(cam < routes[i][0]){
                answer++;
                cam = routes[i][1];
            }
        }
        
        return answer;
    }
}