import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        for(int i=0; i<queue2.length; i++){
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        if((sum1 + sum2)/2==1)
            return -1;
        long half = (sum1 + sum2) / 2;
        
        while(true){
            
            if(sum1 == half){
                break;
            }
            
            if(answer > queue1.length * 4){
                answer = -1;
                break;
            }
            
            if(sum1 > half){
                int n = q1.peek();
                sum1 -= n;
                q2.add(q1.poll());
                sum2 += n;
            } else if(sum1 < half){
                int n = q2.peek();
                sum2 -= n;
                q1.add(q2.poll());
                sum1 += n;
            }
            answer++;
        }
        
        return answer;
    }
}