import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            String result = rotateString(s, i);
            if(isCorrectString(result)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public String rotateString(String s, int size){
        char[] temp = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i=size; i<temp.length; i++){
            sb.append(temp[i]);
        }
        
        for(int i=0; i<size; i++){
            sb.append(temp[i]);
        }
        return sb.toString();
    }
    
    public boolean isCorrectString(final String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);   
            
            if(!stack.isEmpty()){
                char top = stack.peek();
                if(top == '(' && c == ')')
                    stack.pop();
                else if(top == '{' && c == '}')
                    stack.pop();
                else if(top == '[' && c == ']')
                    stack.pop();    
                else 
                    stack.push(c);
            } else {
                stack.push(c);
            }
        }
        
        if(stack.isEmpty())
            return true;
        
        return false;
    }
}