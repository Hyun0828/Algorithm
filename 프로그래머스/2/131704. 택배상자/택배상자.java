import java.util.*;

class Solution {
    public int solution(int[] order) {        
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int currentBox = 1;
        int idx = 0;
        
        // 5 4 3 2 1
        // 1 2 3 4 5
        
        while(true){
            if(currentBox > order.length || currentBox != order[idx]){
                boolean flag = true;
                // 보조컨테이너에서 꺼낼 수 있으면
                while(!stack.isEmpty()){
                    if(stack.peek() == order[idx]){
                        count++;
                        stack.pop();
                        idx++;
                    } else {
                        flag = false;
                        break;
                    }
                }
                
                if(!flag && currentBox == order.length && currentBox != order[idx]){
                    break;
                }
                
                if(idx == order.length)
                    break;
                
                stack.push(currentBox++);
            } else {
                count++;
                currentBox++;
                if(idx < order.length - 1)
                    idx++;
            }
        }
        
        return count;
    }
}