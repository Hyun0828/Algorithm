import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int size = 0;
        
        for(int num : arr){
            if(num % divisor == 0)
                size++;
        }
        
        if(size > 0){
            answer = new int[size];
            int idx = 0;
            for(int num: arr){
                if(num % divisor == 0)
                    answer[idx++] = num;
            }

            Arrays.sort(answer);
        } else
            answer = new int[]{-1};
        
        return answer;
    }
}