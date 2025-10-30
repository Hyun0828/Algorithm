import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // 그래프로 만들었을 때 순위가 어떻게 정해지지?
        // 단방향 + 방향 그래프
        
        int[][] graph = new int[n+1][n+1];
        for(int i=0; i<results.length; i++){
            graph[results[i][0]][results[i][1]] = 1;
        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1)
                        graph[i][j] = 1;
                }
            }
        }
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=n; j++){
                if(graph[i][j] == 1 || graph[j][i] == 1)
                    count++;
            }
            if(count == n - 1)
                answer++;
        }
        
        //   1 2 3 4 5
        // 1   1     1
        // 2         1
        // 3   1     1
        // 4   1 1   1
        // 5     
        
        
        return answer;
    }
}