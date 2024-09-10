import java.util.*;

class Solution {
    public int solution(int n) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int temp = n;
        
        while(true){
            if(temp == 0){
                break;
            }
            stack.push(temp%3);
            temp/=3;
        }
        
        int idx = 0;
        while(!stack.isEmpty()){
            int num = stack.pop();
            System.out.println(num);
            answer += num * Math.pow(3, idx);
            idx++;
        }
        
        return answer;
    }
}