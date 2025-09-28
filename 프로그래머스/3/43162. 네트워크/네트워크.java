import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        // 1 1 0
        // 1 1 0
        // 0 0 1
        
        // 연결되었는지 확인 -> 그래프 탐색 -> dfs/bfs
        // 그래프를 저장하는 자료구조 -> 행렬/연결리스트
        // 탐색 안 한 노드를 찾아서 탐색 하면서 탐색 횟수 = 네트워크 개수
        
        while(true){
            int start = findStart(n);
            if(start != -1){
                bfs(computers, n, start);
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
    
    public int findStart(int n){
        for(int i=0; i<n; i++){
            if(!visited[i])
                return i;
        }
        return -1;
    }
    
    public void bfs(int[][] computers, int n, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int i=0; i<n; i++){
                if(i==cur)
                    continue;
                
                int computer = computers[cur][i];
                if(computer == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}