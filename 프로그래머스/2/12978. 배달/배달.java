import java.util.*;

class Solution {
    
    static int[][] graph;
    static int[] distance;
    static boolean[] visited;
    static int INF = Integer.MAX_VALUE;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        graph = new int[N+1][N+1];
        distance = new int[N+1];
        Arrays.fill(distance, INF);
        visited = new boolean[N+1];
        
        for(int i=1; i<=N; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i=0; i<road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];
        
            graph[from][to] = Math.min(graph[from][to], weight);
            graph[to][from] = Math.min(graph[to][from], weight);
        }
        
        Dijkstra(N);
        
        for(int i=1; i<=N; i++){
            if(distance[i] <= K)
                answer++;
        }
        
        
        return answer;
    }
    
    public static void Dijkstra(int N){
        distance[1] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(1, 0));
        
        while(!pq.isEmpty()){
            Edge current = pq.poll(); // 최단 거리 노드 꺼내기
            int u = current.to;
            
            if(visited[u])
                continue;
            visited[u] = true; // 집합 S에 포함시키기
            
            for(int i=1; i<=N; i++){
                if(!visited[i] && graph[u][i] != INF && distance[i] > distance[u] + graph[u][i]){
                    distance[i] = distance[current.to] + graph[u][i];
                    pq.offer(new Edge(i, distance[i]));
                }
            }            
        }
    }
    
    public static class Edge {
        int to;
        int weight;
        
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}