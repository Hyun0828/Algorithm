import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(!pq.isEmpty()){
            int least = pq.peek();
            if(least >= K){
                break;
            }
            
            int a = pq.poll();
            if(pq.isEmpty()){
                answer = -1;
                break;
            }
            int b = pq.poll();
            pq.add(a+b*2);
            answer++;
        }
        
        return answer;
    }
}