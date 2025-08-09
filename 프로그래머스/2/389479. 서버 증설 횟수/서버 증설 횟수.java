import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<players.length; i++){
            int player = players[i];
            int time = i;
            int needServer = player / m; 
            
            while(!queue.isEmpty() && queue.peek() <= time){
                queue.poll();
            }
            
            int nowServer = queue.size();
            if(nowServer >= needServer)
                continue;
            
            for(int j=0; j<needServer - nowServer; j++){
                answer++;
                queue.add(time+k);
            }
        }
        
        
        return answer;
    }
}