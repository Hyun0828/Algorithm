import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = (brown+4)/2;
        int mul = brown+yellow;
        int sub = (int)Math.sqrt(sum*sum-4*mul);
        
        int width = Math.max((sum+sub)/2, (sum-sub)/2);
        int height = Math.min((sum+sub)/2, (sum-sub)/2);
        
        answer[0] = width;
        answer[1] = height;
        
        return answer;
    }
}