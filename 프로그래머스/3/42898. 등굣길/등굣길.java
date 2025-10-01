import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {        
        int[][] map = new int[n][m];
        int N = 1000000007;
        
        for(int i=0; i<puddles.length; i++){
            int x = puddles[i][0];
            int y = puddles[i][1];
            map[y-1][x-1] = -1;
        }
        
        map[0][0] = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == -1){
                    map[i][j] = 0;
                    continue;
                }
                if(i>0) map[i][j] = ((map[i][j] % N) + (map[i-1][j] % N)) % N;
                if(j>0) map[i][j] = ((map[i][j] % N) + (map[i][j-1] % N)) % N;
            }
        }
        
        return map[n-1][m-1] % N;
    }
}