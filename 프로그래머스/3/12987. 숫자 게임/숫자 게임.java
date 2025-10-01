import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // 맞네, 문제에선 순서대로 게임을 한다고 했으나, A의 순서를 고정시킬 필요는 없다.
        
        // 1 5 7 7
        // 2 2 4 8
        
        // 7 5 3 1
        // 8 6 2 2
        
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>();
        
        for(int i=0; i<A.length; i++){
            pqA.add(A[i]);
            pqB.add(B[i]);
        }
        
        while(!pqB.isEmpty()){
            if(pqA.peek() < pqB.peek()){
                pqA.poll();
                pqB.poll();
                answer++;
            } else {
                pqB.poll();
            }
        }
        
        return answer;
    }
}