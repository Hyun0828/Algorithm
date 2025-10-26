import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int len = s.length();
        
        for(int i=1; i<=len/2; i++){
            answer = Math.min(answer, comp(s, i));
        }
        
        return answer;
    }
    
    public int comp(String s, int len){
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length()-len; i+=len){
            String s1 = s.substring(i, i+len);
            int count = 1;
            int j = i+len;
            
            for(j=i+len; j<s.length(); j+=len){
                if(j+len > s.length())
                    break;
                String s2 = s.substring(j, j+len);
                if(s1.equals(s2)){
                    count++;
                    i = j;
                } else {
                    break;
                }
            }
            
            if(count > 1)
                sb.append(count);
            sb.append(s1);
            
            if(j != s.length() && j+len >= s.length()){
                sb.append(s.substring(j));
            }
        }
        
        return sb.toString().length();
    }
}