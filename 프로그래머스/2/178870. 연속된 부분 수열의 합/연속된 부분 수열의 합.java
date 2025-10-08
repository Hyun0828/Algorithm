import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = 10000000;
        
        while(true) {
            if(sum > k){
                sum -= sequence[left++];
            } else if (sum < k){
                if(right == sequence.length)
                    break;
                sum += sequence[right++];
            } else {
                if(right - left < len){
                    answer[0] = left;
                    answer[1] = right - 1;
                    len = right - left;
                }
                sum -= sequence[left++];
            }
        }
        return answer;
    }
}