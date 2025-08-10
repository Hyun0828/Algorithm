import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            int i = n % 3;
            if(i==0){
                i=4;
                n = n/3 - 1;
            } else {
                n = n/3;
            }
            sb.append(i);
        }
        return sb.reverse().toString();
    }
}