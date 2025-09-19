import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        while(true){
            int idx = isComplete(n);
            if(idx == -1)
                break;
            bfs(idx, n, computers);
            answer++;
        }
        return answer;
    }
    
    public int isComplete(int n){
        for(int i=0; i<n; i++){
            if(!visited[i])
                return i; 
        }
        return -1;
    }
    
    public void bfs(int start, int n, int[][] computers){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            
            if(visited[current])
                continue;
            visited[current] = true;
            
            for(int i=0; i<n; i++){
                if(i!=n && computers[current][i] == 1){
                    if(!visited[i])
                        queue.add(i);
                }
            }
        }
    }
}
