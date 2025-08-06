import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start=0;
        int end=0;
        int sum=0;
        int length=10000000;
        
        while(true){
            if(sum > k){
                sum -= sequence[start++];
            } else if (sum == k && length > end - start){
                answer[0] = start;
                answer[1] = end - 1;
                length = end - start;
                sum -= sequence[start++];
            } else {
                if(end == sequence.length)
                    break;
                sum += sequence[end++];
            }   
        }
        return answer;
    }
}