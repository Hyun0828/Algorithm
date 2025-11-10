import java.util.*;

class Solution {
    
    int INF = Integer.MAX_VALUE;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 1. 따로 타고 가는 경우 : 다익스트라 1번
        // 2. 같이 타고 가는 경우
        // 2-1. 1번까지 같이 가는 경우 -> 4-1 최단 경로 + 1에서 a,b로 최단거리
        // 2-2. 5번까지 같이 가는 경우 -> 1-5 최단 경로 + 5에서 a,b로 최단거리
        
        int[][] graph = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j)
                    continue;
                graph[i][j] = INF;
            }
        }
        
        for(int i=0; i<fares.length; i++){
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            
            graph[c][d] = f;
            graph[d][c] = f;
        }
        prim(graph, n);
        
        int sum = 0;
        // 1. 따로 가는게 빠른 경우
        sum += (graph[s][a] + graph[s][b]);
        // 2. 같이 가는 경우
        for(int i=1; i<=n; i++){
            int tmp = 0;
            if(graph[s][i] == INF || graph[i][a] == INF || graph[i][b] == INF)
                continue;
            tmp += graph[s][i] + graph[i][a] + graph[i][b];
            sum = Math.min(sum, tmp);
        }
        
        return sum;
    }
    
    public void prim(int[][] graph, int n){
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(graph[i][k] != INF && graph[k][j] != INF)
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }
}