import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int i = 0;

        // 일단 병사로 막고, 병사로 못 막는 시기가 오면 그 전에 병사로 막은 숫자 중에 최댓값을 무조건을 쓴다
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(i=0; i<enemy.length; i++){
            n -= enemy[i];
            pq.add(enemy[i]);
            
            if(n >= 0){
                continue;
            }
            
            if(k==0)
                break;
            
            n += pq.poll();
            k--;
        }
        
        return i;
    }
}