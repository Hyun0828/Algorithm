import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Pair> s = new Stack<>();
        for(int i=numbers.length-1; i>=0; i--){
            
            while(!s.isEmpty()){
                Pair p = s.peek();
                
                if(numbers[i] < p.value){
                    answer[i] = p.value;
                    s.push(new Pair(numbers[i], p.idx));
                    break;
                } else {
                    s.pop();
                }
            }
            
            if(s.isEmpty()){
                s.push(new Pair(numbers[i], i));
                answer[i] = -1;
            }
        }
            
        
        return answer;
    }
    
    static class Pair {
        int value;
        int idx;
        
        public Pair(int value, int idx){
            this.value = value;
            this.idx = idx;
        }
    }
}