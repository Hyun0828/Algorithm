import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int i, j, k;
        
        for(i = 1; i <= s.length(); i++){
            String res = "";
            for(j = 0; j < s.length(); ){
                String sub = s.substring(j, Math.min(j + i, s.length()));
                int sum = 1;
                
                k = j + i;
                while(k + i <= s.length()){
                    String n = s.substring(k, k + i);
                    if(sub.equals(n)){
                        sum++;
                        k += i;
                    } else {
                        break;
                    }   
                }
                if(sum > 1)
                    res += sum;
                res += sub;
                j = k;
            }
            answer = Math.min(answer, res.length());
        }
        return answer;
    }
}