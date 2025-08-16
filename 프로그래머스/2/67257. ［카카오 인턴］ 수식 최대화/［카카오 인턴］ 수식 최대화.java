import java.util.*;

class Solution {
    
    public long solution(String expression) {
        List<String> tokens = tokenize(expression);
        List<String> ops = new ArrayList<>();
        if(expression.indexOf('+') >= 0)
            ops.add("+");
        if(expression.indexOf('-') >= 0)
            ops.add("-");
        if(expression.indexOf('*') >= 0)
            ops.add("*");
        
        // 연산자 순서 만들기 (순열 -> DFS)
        List<List<String>> orders = new ArrayList<>();
        permute(ops, new boolean[ops.size()], new ArrayList<>(), orders);
        
        long answer = 0;
        for(List<String> order : orders){
            long result = calculate(new ArrayList<>(tokens), order);
            answer = Math.max(answer, Math.abs(result));
        }
        
        return answer;
    }
    
    private List<String> tokenize(String s){
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                tokens.add(sb.toString());
                sb.setLength(0);
                tokens.add(String.valueOf(c));
            } else {
                sb.append(c);
            }
        }
        if(sb.length() > 0)
            tokens.add(sb.toString());
        
        return tokens;
    }
    
    private void permute(List<String> ops, boolean[] used, List<String> path, List<List<String>> orders){
        if(path.size() == ops.size()){
            orders.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=0; i<ops.size(); i++){
            if(used[i])
                continue;
            used[i] = true;
            path.add(ops.get(i));
            permute(ops, used, path, orders);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
    
    private long calculate(List<String> tokens, List<String> order){
        for(int i=0; i<order.size(); i++){
            String op = order.get(i);
            
            for(int j=0; j<tokens.size(); ){
                String s = tokens.get(j);
                
                // 연산자면
                if(s.equals(op)){
                    long a = Long.parseLong(tokens.get(j-1));
                    long b = Long.parseLong(tokens.get(j+1));
                    long c;
                    if(s.equals("+")){
                        c = a + b;
                    } else if(s.equals("-")){
                        c = a - b;
                    } else {
                        c = a * b;
                    }
                    
                    tokens.set(j-1, String.valueOf(c));
                    tokens.remove(j);
                    tokens.remove(j);
                    j--;
                } else {
                    j++;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }
}

    