import java.util.*;

class Solution {
    
    List<Edge>[] graph;
    int[] distance;
    boolean[] visited;
    int INF = Integer.MAX_VALUE;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        distance = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(distance, INF);
        
        for(int i=0; i<roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            graph[a].add(new Edge(b, 1));
            graph[b].add(new Edge(a, 1));
        }
        
        dijkstra(n, destination);
        
        for(int i=0; i<sources.length; i++){
            int source = sources[i];
            if(distance[source] != INF){
                answer[i] = distance[source];
            } else {
                answer[i] = -1; 
            }
        }
        
        return answer;
    }
    
    public void dijkstra(int n, int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Edge(start, 0));
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int u = cur.to;
            int w = cur.weight;
            
            if(visited[u])
                continue;
            visited[u] = true;
            
            for(Edge e : graph[u]){
                int v = e.to;
                int dis = e.weight;
                if(!visited[v] && distance[v] > distance[u] + dis){
                    distance[v] = distance[u] + dis;
                    pq.add(new Edge(v, distance[v]));
                }
            }
        }
    }
    
    public static class Edge implements Comparable<Edge>{
        int to;
        int weight;
        
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
}