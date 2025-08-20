import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        int g = gcd(Math.max(w, h), Math.min(w, h));
        int nw = w / g;
        int nh = h / g;
        if(g == 1){
            answer += nw + nh - 1; 
        } else {
            int tmp = nw + nh - 1;
            answer += tmp * g;
        }
        
        return (long)w * h - answer;
    }
    
    public int gcd(int a, int b){
        int n = a;
        int m = b;
        
        while(true){
            int r = n % m;
            if(r==0){
                break;
            }
            n = m;
            m = r;
        }
        
        return m;
    }
}