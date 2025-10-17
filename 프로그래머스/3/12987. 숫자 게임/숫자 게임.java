import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // 1. A팀의 순서가 정해져 있다곤 하지만, 문제를 풀 때 그 순서를 지킬 필요는 없다.
        // 2. A팀에서 내는 숫자보다 가장 작은 차이로 이겨야겠지
        // 3. A팀에서 가장 작은 숫자를 내면, B팀에서도 가장 작은 숫자를 내야한다.
        
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
            } else{
                pqB.poll();
            }
        }
        
        return answer;
    }
}