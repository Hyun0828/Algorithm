import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> sum_of_arr = new HashSet<>();
        
        // 0,7,9,1,1,4,7,9,1,1
        int[] temp_elements = new int[elements.length * 2];
        for(int i=1; i<temp_elements.length; i++){
            if(i <= elements.length){
                temp_elements[i] = elements[i - 1];
            } else {
                temp_elements[i] = elements[i - 1 - elements.length];
            }
        }
        
        // 누적합
        for(int i=1; i<temp_elements.length; i++){
            temp_elements[i] += temp_elements[i-1];
        }
        
        for(int i=1; i<=elements.length; i++){
            int len = i;
            for(int j=len; j<temp_elements.length; j++){
                int sum = temp_elements[j] - temp_elements[j-len];
                sum_of_arr.add(sum);
            }
        }
        
        return sum_of_arr.size();
    }
}