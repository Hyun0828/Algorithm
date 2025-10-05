import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int right = 1;
        int left = stations[0] - w;
        
        double d = (double)(left - right) / (2 * w + 1);
        answer += (int)Math.ceil(d);
        
        for(int i=1; i<stations.length; i++){
            right = stations[i-1] + w;
            left = stations[i] - w;
            
            if(right >= left)
                continue;
            
            double t = (double)(left - right - 1) / (2 * w + 1);
            answer += (int)Math.ceil(t);
        }
        
        if(stations[stations.length-1] + w < n){
            right = stations[stations.length-1] + w;
            left = n;
            
            d = (double)(left - right) / (2 * w + 1);
            answer += (int)Math.ceil(d);
        }

        return answer;
    }
}