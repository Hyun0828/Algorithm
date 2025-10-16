import java.util.*;

class Solution {
    
    List<String> ops = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    char[] arr = new char[]{'+', '-', '*'};
    
    public long solution(String expression) {
        long answer = 0;
        
        String[] n = expression.split("[+\\-*]");
        List<Long> nums = new ArrayList<>();
        for (String s : n)
            nums.add(Long.parseLong(s));
        
        String[] o = expression.split("[0-9]+");
        List<String> opList = new ArrayList<>();
        for (String s : o) {
            if (!s.equals("")) opList.add(s);
        }
        
        permutation("");
        for(String op : ops){
            long result = calculate(nums, opList, op);
            answer = Math.max(answer, Math.abs(result));
        }
        
        return answer;
    }
    
    public long calculate(List<Long> numList, List<String> opList, String opOrder){
        List<Long> nums = new ArrayList<>(numList);
        List<String> ops = new ArrayList<>(opList);
        
        for(int i=0; i<opOrder.length(); i++){
            char op = opOrder.charAt(i);
            for(int j=0; j<ops.size(); j++){
                if(ops.get(j).charAt(0) == op){
                    long res = operate(nums.get(j), nums.get(j+1), op);
                    nums.remove(j+1);
                    nums.set(j, res);
                    ops.remove(j);
                    j--;
                }
            }
        }
        return nums.get(0);
    }
    
    public long operate(long a, long b, char op){
        if(op == '+')
            return a+b;
        if(op == '-')
            return a-b;
        return a*b;
    }
    
    public void permutation(String s){
        if(s.length() == 3){
            ops.add(s);
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            if(visited.contains(i))
                continue;
            visited.add(i);
            permutation(s+arr[i]);
            visited.remove(i);
        }
    }
}