import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    boolean[] visited;
    int[] distance;
    int INF = 100000000;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {        
        init(n, roads);
        visited[destination] = true;
        distance[destination] = 0;
        
        dijkstra(destination);
        
        int[] answer = new int[sources.length];
        for(int i=0; i<answer.length; i++){
            answer[i] = distance[sources[i]] != INF ? distance[sources[i]] : -1;
        }
        
        return answer;
    }
    
    public void init(int n, int[][] roads){
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            graph[i] = new ArrayList<>();
        
        visited = new boolean[n+1];
        distance = new int[n+1];
        Arrays.fill(distance, INF);
        
        for(int i=0; i<roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
    }
    
    public void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cNode = cur[0];
            int cDis = cur[1];
            
            List<Integer> edges = graph[cNode];
            for(Integer to : edges){
                if(visited[to])
                    continue;
                if(distance[to] > distance[cNode] + 1){
                    distance[to] = distance[cNode] + 1;
                    pq.add(new int[]{to, distance[to]});
                }
            }
        }
    }
}