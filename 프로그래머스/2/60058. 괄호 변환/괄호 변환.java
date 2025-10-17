import java.util.*;

class Solution {
    public String solution(String p) {
        String w = p;
        
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환한다.
        if(w.equals(""))
            return "";
        
        if(isCorrectString(w))
            return w;
        
        // 2. w를 두 균형잡힌 괄호 문자열 u,v로 분리한다. 단 u는 더 이상 분리할 수 없어야 하며 v는 빈 문자열이 될 수 있다.
        String[] arr = parseString(w);
        String u = arr[0];
        String v = arr[1];
        System.out.println(u + ", " + v);
        
        // 3. 문자열 u가 올바른 괄호 문자열이면 v에 대해 1단계부터 다시 수행하고 그 결과를 u에 이어 붙인 후 반환한다.
        // 4. 아니라면 4번 과정을 수행한다.
        if(isCorrectString(u)){
            return u + solution(v);
        } else {
            String s = "(";
            s += solution(v);
            s += ")";
            for(int i=1; i<u.length()-1; i++){
                if(u.charAt(i) == '(')
                    s += ")";
                else
                    s += "(";
            }
            return s;
        }
    }
    
    public String[] parseString(String w){
        String u = "";
        String v = "";
        int n1 = 0;
        int n2 = 0;
        for(int i=0; i<w.length(); i++){
            if(w.charAt(i) == '(')
                n1++;
            else
                n2++;
            
            if(n1 == n2){
                u = w.substring(0, i+1);
                v = w.substring(i+1);
                break;
            }
        }
        return new String[]{u, v};
    }
    
    public boolean isCorrectString(String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '(')
                stack.push(c);
            else {
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}