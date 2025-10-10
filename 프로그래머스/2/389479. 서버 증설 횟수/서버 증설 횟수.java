import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // 증설된 서버 관리 (증설된 서버의 종료 시각을 큐에 순서대로 넣는다)
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<players.length; i++){
            while(!queue.isEmpty() && queue.peek() == i){
                queue.poll();
            }
            int player = players[i];
            int n = queue.size();

            // 어느 시간대의 이용자가 m명 미만이라면, 서버 증설이 필요하지 않다.
            if(player < m){
                continue;
            }
            
            // target대의 서버가 필요한 상황에서,
            int target = player / m;
            for(int j=n; j<target; j++){
                answer++;
                queue.add(i + k);
            }
        }
        
        return answer;
    }
}