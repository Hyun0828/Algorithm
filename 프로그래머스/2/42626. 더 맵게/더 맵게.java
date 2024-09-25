import java.util.*;

class Solution {
    
    int answer = 0;
    PriorityQueue<Integer> heap = new PriorityQueue<>();  
    
    public int solution(int[] scoville, int K) {
        // 최소힙에 다 넣고
        insert(scoville);
        // 하나씩 꺼내면서 K보다 작은 스코빌 음식이 2개 꺼내지면 더하고, K보다 작으면 다시 힙에 추가
        if(solve(K))
            return answer;
        else
            return -1;
    }
    
    private void insert(int[] scoville){
        for(int s : scoville)
            heap.add(s);
    }
    
    private boolean solve(int K){
        
        boolean flag = true;
        
        while(heap.peek() < K){
            
            if(heap.size() >= 2){
                int mix = heap.poll() + 2 * heap.poll();
                heap.add(mix);
                answer++;    
            }
            else if(heap.size() <= 1){
                flag = false;
                break;
            }
        }
        
        return flag;
    }
}