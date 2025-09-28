import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        // 1. 길이가 100만이니까 완탐은 시간초과
        // 2. 정렬 시킬 수 없으니까 이분탐색 불가능
        // 3. DP? 뒤에 있는 숫자 정보가 필요하니까 뒤에서 부터 시작하긴 해야 한다. 아닌거같긴함
        // 4. stack의 냄새가 나긴 하는데, 
        Stack<Integer> stack = new Stack<>();
        for(int i=numbers.length-1; i>=0; i--){
            if(stack.isEmpty()){
                answer[i] = -1;
                stack.push(numbers[i]);
            } else {
                while(!stack.isEmpty() && numbers[i] >= stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty())
                    answer[i] = -1;
                else 
                    answer[i] = stack.peek();
                stack.push(numbers[i]);
            }
        }
        
        return answer;
    }
}