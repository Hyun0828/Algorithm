import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(); 
        
        boolean isFirstChar = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 공백이면 그대로 두고 다음 문자를 첫 문자로 간주
            if(c == ' ') {
                sb.append(c);
                isFirstChar = true;
            }
            // 숫자면 그대로 추가
            else if(Character.isDigit(c)) {
                sb.append(c);
                isFirstChar = false;
            }
            // 알파벳이면
            else {
                if(isFirstChar) {
                    sb.append(Character.toUpperCase(c));
                    isFirstChar = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        
        return sb.toString();
    }
}