import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // 1. 남은 작업을 다 할 수 있으면 피로도는 0이다
        // 2. 제곱의 합이 최소가 되게 하려면 어떻게?
        // 3. 제곱수는 숫자가 커질수록 기하급수적으로 커지기 때문에, 큰 숫자를 줄여가는 것이 맞다.
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for(int i=0; i<works.length; i++){
            sum += works[i];
            pq.add(works[i]);
        }
        if(sum <= n)
            return 0;
        
        while(n > 0){
            int a = pq.poll();
            pq.add(a - 1);
            n--;
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}