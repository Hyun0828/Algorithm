import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        int size = Long.toString(n).length();
        int[] answer = new int[size];
        int idx = 0;
        
        while(n > 0){
            answer[idx++] = (int)(n%10);
            n /= 10;
        }
        
        return answer;
    }
}