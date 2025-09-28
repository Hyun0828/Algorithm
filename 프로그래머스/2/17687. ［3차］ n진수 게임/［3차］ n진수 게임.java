import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int number = 0; // 현재 숫자
        int index = 1; // 차례(순번)
        boolean isEnd = false;
        
        while(true){
            String s = Integer.toString(number, n);
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i); // 한 사람은 c 하나씩 돌아가면서 말한다.
                c = Character.toUpperCase(c);
                // 튜브의 차례일 때
                int idx = index % m;
                if(idx == 0)
                    idx = m;
                if(idx == p){
                    answer += c;
                    if(answer.length() == t){
                        isEnd = true;
                        break;
                    }
                }
                index++;
            }
            if(isEnd)
                break;
            number++;
        }
        
        return answer;
    }
}