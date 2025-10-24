import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 0;
        
        // 홀수 팰린드롬
        for(int i=0; i<s.length(); i++){
            int left = i - 1;
            int right = i + 1;
            int len = 1;
            
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                len += 2;
            }
            answer = Math.max(answer, len);
        }
        
        // 짝수 팰린드롬
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                int left = i;
                int right = i+1;
                int len = 0;
                
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                    len += 2;
                }
                answer = Math.max(answer, len);
            }
        }

        return answer;
    }
}