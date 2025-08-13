import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int i=0;
        for(i=0; i<enemy.length; i++){
            n -= enemy[i];
            pq.offer(enemy[i]);
            
            if(n >= 0)
                continue;
            
            if(k == 0){
                break;
            }
    
            k--;
            n += pq.poll();
        }
        return i;
    }
}
