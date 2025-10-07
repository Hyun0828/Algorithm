import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] % 2 == 0)
                answer[i] = numbers[i] + 1;
            else {
                StringBuilder sb = new StringBuilder();
                String s = Long.toString(numbers[i], 2);
                int idx = -1;
                for(int j=s.length()-1; j>=0; j--){
                    if(s.charAt(j) == '0'){
                        idx = j;
                        break;
                    }
                }
                
                if(idx == -1){
                    sb.append('1');
                    sb.append('0');
                    for(int j=1; j<s.length(); j++){
                        sb.append(s.charAt(j));
                    }
                } else {
                    for(int j=0; j<s.length(); j++){
                        if(idx != j){
                            sb.append(s.charAt(j));
                        } else {
                            sb.append('1');
                            sb.append('0');
                            j++;
                        }
                    }
                }
                
                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }
        
        // n이 짝수면 n+1
        // n이 홀수면,
        
        // 2 : 0010
        // 3 : 0011
        // 4 : 0100
        // 5 : 0101
        // 6 : 0110
        // 7 : 0111
        // 8 : 1000
        // 9 : 1001
        // 10 : 1010
        // 11 : 1011
        // 12 : 1100
        // 13 : 1101
        // 14 : 1110
        // 15 : 1111
        // 16 : 10000
        // 10001
        // 10010
        // 10011
        // 10100
        // 10101
        
        return answer;
    }
}