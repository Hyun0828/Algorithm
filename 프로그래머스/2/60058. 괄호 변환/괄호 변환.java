import java.util.*;

class Solution {
    public String solution(String p) {
        return solve(p);
    }
    
    public String solve(String p){
        // 1. 빈 문자열이면 빈 문자열 반환
        if(p.isEmpty()){
            return "";
        }
        // 올바른 괄호 문자열이라면 그대로 반환
        if(isCorrectString(p)){
            return p;
        }
        
        // 2. 균형잡힌 괄호 문자열 u, v로 분리
        String[] uv = splitString(p);
        String u = uv[0];
        String v = uv[1];
        
        // 3. u가 올바른 괄호 문자열 이라면 v에 대해 1단계부터 수행 후 u에 이어 붙인 후 반환
        if(isCorrectString(u)){
            return u + solve(v);
        }
        
        // 4. u가 올바른 괄호 문자열이 아니라면
        String result = "(";
        result += solve(v);
        result += ")";
        // 4-4. u의 첫, 마지막 문자를 제거하고 나머지 문자열의 괄호 방향을 뒤집어 붙인다.
        result += reverseString(u);
        return result;
        
    }
    
    public boolean isCorrectString(String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    public String[] splitString(String s){
        String[] temp = new String[2];
        
        if(s.length() == 2){
            temp[0] = s;
            temp[1] = "";
            return temp;
        }
        
        for(int i=2; i<=s.length(); i+=2){
            int num1 = 0;
            int num2 = 0;
            for(int j=0; j<i; j++){
                if(s.charAt(j) == '(')
                    num1++;
                else
                    num2++;
            }
            if(num1 == num2){
                temp[0] = s.substring(0, i);
                temp[1] = s.substring(i, s.length());
                break;
            }
        }
        return temp;
    }
    
    public String reverseString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<s.length()-1; i++){
            char c = s.charAt(i);
            if(c == '(')
                sb.append(')');
            else
                sb.append('(');
        }
        return sb.toString();
    }
}