import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        // 3 2 7 2
        // 4 6 5 1
        
        // 어쨋든 한쪽만 합의 절반이 되면 반대는 자연스럽게 절반이 된다.
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        long tmp = 0;
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        tmp = sum1;
        for(int i=0; i<queue2.length; i++){
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        if(sum1 == sum2)
            return 0;
        
        if((sum1+sum2)%2==1)
            return -1;
        
        long half = (sum1+sum2) / 2;
        
        while(true){
            
            if(sum1 == half){
                break;
            }
            
            if(answer > queue1.length * 4){
                answer = -1;
                break;
            }
            
            if(sum1 < half){
                int n = q2.poll();
                sum2 -= n;
                q1.add(n);
                sum1 += n;
            } else if(sum1 > half){
                int n = q1.poll();
                sum1 -= n;
                q2.add(n);
                sum2 += n;
            }
            
            answer++;
        }
        
        
        return answer;
    }
}