import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 가로(w), 세로(h)
        // brown = 2*(w+h) - 4;
        // yellow = w*h - brown;
        
        // brown/2+2 = w+h
        // brown+yellow = wh
        
        int m = brown+yellow;
        for(int i=m; i>=0; i--){
            if(m % i == 0){
                int w = Math.max(m/i, i);
                int h = Math.min(m/i, i);
                
                if(w+h == brown/2 + 2){
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        
        return answer;
    }
}