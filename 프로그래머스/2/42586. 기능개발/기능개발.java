import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        for(int i=progresses.length-1; i>=0; i--){
            int day = (int)Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            stack.push(day);
        }
        
        int day = stack.pop();
        int count = 1;
        while(!stack.isEmpty()){
            if(day >= stack.peek()){
                count++;
                stack.pop();
            } else {
                answer.add(count);
                day = stack.pop();
                count = 1;
            }
        }
        
        if(count >= 1)
            answer.add(count);
        
        int[] result = new int[answer.size()];
        for(int i=0; i<result.length; i++)
            result[i] = answer.get(i);
        
        return result;
    }
}