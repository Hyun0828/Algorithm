import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        permutation(k, dungeons, new HashSet<>());
        return answer;
    }
    
    public void permutation(int k, int[][] dungeons, Set<Integer> visited){
        answer = Math.max(answer, visited.size());
        
        if(visited.size() == dungeons.length)
            return;
        
        for(int i=0; i<dungeons.length; i++){
            if(visited.contains(i))
                continue;
            
            if(k >= dungeons[i][0] && k >= dungeons[i][1]){
                visited.add(i);
                permutation(k-dungeons[i][1], dungeons, visited);
                visited.remove(i);
            }
        }
    }
}