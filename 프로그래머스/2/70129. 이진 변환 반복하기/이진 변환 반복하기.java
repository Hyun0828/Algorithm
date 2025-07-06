import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int countOfZero = 0;
        int countOfConvert = 0;
        
        while(true) {
            // 1. 모든 0을 제거한다
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '0') {
                    countOfZero++;
                    continue;    
                }
                sb.append(s.charAt(i));
            }
            String t = sb.toString();
            int len = t.length();
            
            // 2. 길이를 2진법으로 표현한 문자열로 바꾼다.
            s = Integer.toBinaryString(len);
            countOfConvert++;
            if(s.equals("1")) {
                break;
            }
        }
        answer[0] = countOfConvert;
        answer[1] = countOfZero;
        return answer;
    }
}