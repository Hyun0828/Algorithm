import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0){
            int r = storey % 10;
            System.out.println(storey + ", " + answer);
            
            // 만약 r이 5라면, 그 윗자리수를 봐야한다.
            if(r == 5){
                int q = (storey / 10) % 10;
                if(q < 5) {
                    storey -= r;
                    answer += r;
                } else if(q > 5){
                    storey += r;
                    answer += r;
                } else {
                    storey += r;
                    answer += r;
                }
            } else if(r < 5){
                storey -= r;
                answer += r;
            } else {
                storey += (10 - r);
                answer += (10 - r);
            }
            storey /= 10;
        }

        return answer;
    }
}