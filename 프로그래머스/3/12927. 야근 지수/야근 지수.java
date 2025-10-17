import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // 남은 숫자들의 제곱의 합이 최소가 되어야 한다.
        // 근데 제곱수의 특징을 생각해보면, 숫자가 커질수록 기하급수적으로 커진다
        // 그냥 최댓값에서 1씩 빼면 되지 않을까?
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
            sum += works[i];
        }
        
        if(sum <= n)
            return 0;
        
        while(n > 0){
            int max = pq.poll();
            max -= 1;
            n -= 1;
            pq.add(max);
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}