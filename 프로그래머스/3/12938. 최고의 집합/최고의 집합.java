import java.util.*;

class Solution {
    public int[] solution(int n, int s) {    
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int num = s/n;
        int r = s - num*n;
        if(num == 0)
            return new int[]{-1};
        
        int[] answer = new int[n];
        for(int i=0; i<n; i++)
            answer[i] = num;
        
        // if(r > 0){
        //     for(int i=0; i<r; i++){
        //         int t = pq.poll();
        //         pq.add(t + 1);
        //     }
        // }
        
        if(r > 0){
            for(int i=n-1; i>=n-r; i--){
                answer[i]++;
            }
        }
        
        return answer;
    }
}