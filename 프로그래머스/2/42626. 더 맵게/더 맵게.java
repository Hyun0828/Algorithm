import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(true){
            if(!pq.isEmpty() && pq.peek() >= K)
                break;
            
            if(pq.size() == 1 && pq.peek() < K)
                return -1;
            
            if(pq.size() >= 2){
                int s1 = pq.poll();
                int s2 = pq.poll();
                pq.add(s1 + 2 * s2);
                answer++;
            }
        }
        
        
        return answer;
    }
}