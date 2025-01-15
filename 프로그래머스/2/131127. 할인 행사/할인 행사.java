import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> items = new HashMap<>();
        for(int i=0; i<10; i++){
            items.put(discount[i], items.getOrDefault(discount[i], 0) + 1);
        }
        boolean isMatch = true;
        for (int j = 0; j < want.length; j++) {
            if (items.getOrDefault(want[j], 0) != number[j]) {
                isMatch = false;
                break;
            }
        }
        if(isMatch)
            answer++;
        
        for(int i=1; i<discount.length - 9; i++){
            items.put(discount[i-1], items.getOrDefault(discount[i-1], 0) - 1);
            items.put(discount[i+9], items.getOrDefault(discount[i+9], 0) + 1);
            
            // 검증과정
            isMatch = true;
            for (int j = 0; j < want.length; j++) {
                if (items.getOrDefault(want[j], 0) != number[j]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                answer++;
            }
        }
        
        return answer;
    }
}