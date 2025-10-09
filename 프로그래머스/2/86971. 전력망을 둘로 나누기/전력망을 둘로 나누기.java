import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    boolean[] visited;
    int cnt = 0;
    
    public int solution(int n, int[][] wires) {
        int answer = 1000000000;
        
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i=1; i<=n; i++)
            graph[i] = new ArrayList<>();
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            dfs(1);
            
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
            
            cnt = 0;
            graph[a].add(b);
            graph[b].add(a);
            Arrays.fill(visited, false);
        }
        
        return answer;
    }
    
    public void dfs(int n){
        visited[n] = true;
        cnt++;
        for(Integer i : graph[n]){
            if(visited[i])
                continue;
            dfs(i);
        }
    }
}