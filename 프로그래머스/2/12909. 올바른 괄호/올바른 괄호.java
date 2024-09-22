import java.util.*;

class Solution {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        
        for(char c : arr){
            
            if(!stack.isEmpty()){
                if(c == ')' && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(c);
            }
            else
                stack.push(c);
        }
        
        if(stack.isEmpty())
            return true;
        else
            return false;
        
    }
}