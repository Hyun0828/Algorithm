import java.util.*;

class Solution {
    
    int[][] graph;
    int INF = Integer.MAX_VALUE;
    int[] distance;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(graph[i], INF);
        }
        distance = new int[N+1];
        Arrays.fill(distance, INF);
        
        for(int i=0; i<road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];
            
            graph[from][to] = Math.min(graph[from][to], weight);
            graph[to][from] = Math.min(graph[to][from], weight);
        }
        
        dijkstra(N);
        
        for(int i=1; i<=N; i++){
            if(distance[i] <= K)
                answer++;
        }

        return answer;
    }
    
    public void dijkstra(int N) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        distance[1] = 0;
        
        pq.add(new Edge(1, 0));
        
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int u = edge.to;
            
            if(visited[u])
                continue;
            visited[u] = true;
            
            for(int i=1; i<=N; i++){
                if(!visited[i] && graph[u][i] != INF && distance[i] > distance[u] + graph[u][i]){
                    distance[i] = distance[u] + graph[u][i];
                    pq.add(new Edge(i, distance[i]));
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