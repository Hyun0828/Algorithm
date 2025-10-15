import java.util.*;

class Solution {
    
    List<Edge>[] graph;
    int[] distance;
    boolean[] visited;
    int INF = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            graph[i] = new ArrayList<>();
        distance = new int[n+1];
        Arrays.fill(distance, INF);
        visited = new boolean[n+1];
        
        for(int i=0; i<edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            
            graph[from].add(new Edge(to, 1));
            graph[to].add(new Edge(from, 1));
        }
        
        dijkstra(n);
        
        int max = 0;
        for(int i=1; i<=n; i++){
            max = Math.max(max, distance[i]);
        }
        for(int i=1; i<=n; i++){
            if(distance[i] == max){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dijkstra(int n){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[1] = 0;
        pq.add(new Edge(1, 0));
        visited[1] = true;
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int u = cur.to;
            int w = cur.weight;
            
            for(Edge e : graph[u]){
                int v = e.to;
                if(distance[v] > distance[u] + e.weight){
                    distance[v] = distance[u] + e.weight;
                    pq.add(new Edge(v, distance[v]));
                }
            }
        }
    }
    
    public static class Edge implements Comparable<Edge> {
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