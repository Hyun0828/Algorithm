import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int len = 100000000;
        
        while(true){
            if(sum > k){
                sum -= sequence[left++];
            } else if(sum < k){
                if(right == sequence.length - 1)
                    break;
                sum += sequence[++right];
            } else {
                // 새로 찾은 부분 수열이 더 짧으면
                if(len > right - left + 1){
                    len = right - left + 1;
                    answer[0] = left;
                    answer[1] = right;
                }
                // 아 어차피 먼저 찾은게 무조건 앞에 있어서 안 해도 되는건가?
                sum -= sequence[left++];
            }
        }
        
        return answer;
    }
}