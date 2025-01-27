import java.util.*;

class Solution {
    
    private boolean[] visited;
    private int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        backtracking(k, 0, dungeons);
        
        return max;
    }
    
    public void backtracking(int k, int count, int[][] dungeons){
        
        max = Math.max(max, count);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                backtracking(k-dungeons[i][1], count+1, dungeons);
                visited[i] = false;
            }
        }
    }
}