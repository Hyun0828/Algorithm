import java.util.*;

class Solution {
    
    public String solution(int n) {        
        // 숫자를 3개만 쓴다! 라는 사실이 중요하다. -> 3진법과 동일하다.
        
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int r = n%3;
            if(r==0){
                r=4;
                n = n/3-1;
            } else {
                n=n/3;
            }
            sb.append(r);
        }
        
        return sb.reverse().toString();
    }
    
    
}