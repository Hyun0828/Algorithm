import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] answer = {};
        
        for(int num : arr){
            if(stack.isEmpty())
                stack.push(num);
            else{
                if(stack.peek() == num)
                    continue;
                else{
                    queue.add(stack.pop());
                    stack.push(num);
                }
            }
        }
        queue.add(stack.pop());
        
        answer = new int[queue.size()];
        int idx = 0;
        while(!queue.isEmpty()){
            answer[idx++] = queue.poll();
        }
        
        return answer;
    }
}