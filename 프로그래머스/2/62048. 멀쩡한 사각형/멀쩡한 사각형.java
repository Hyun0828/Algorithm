import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        // 안 잘린 정사각형의 개수를 구하시오.
        
        // 1. w==h이면, answer = wxh - w
        // 2. w나 h중 하나가 1이면 answer = 0
        // 3. w와 h가 서로소이면 w+h-1개 제외
        
        // w h 몇개제외?
        // 2 3 4
        // 2 4 4
        // 2 5 6
        // 2 6 6
        // 2 7 8
        // 2 8 8
        
        // 3 4 6
        // 3 5 7
        // 3 6 8
        // 3 7 9
        // 3 8 10
        
        int g = gcd(w, h);
        int gw = w / g;
        int gh = h / g;
        answer = (long)w * h - (long)(gw + gh - 1) * g;
        
        return answer;
    }
    
    public int gcd(int a, int b){
        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}