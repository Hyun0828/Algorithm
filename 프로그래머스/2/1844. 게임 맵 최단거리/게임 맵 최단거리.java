import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        bfs(maps, n, m);
        
        if(maps[n-1][m-1] == 1)
            return -1;
        return maps[n-1][m-1];
    }
    
    public void bfs(int[][] maps, int n, int m){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 1, 0 ,0};
        int[] dy = {0, 0, -1, 1};
        
        queue.add(new int[]{0, 0});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            
            if(visited[y][x])
                continue;
            visited[y][x] = true;
            
            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] || maps[ny][nx] == 0)
                    continue;
                
                maps[ny][nx] = maps[y][x] + 1;
                queue.add(new int[]{ny, nx});
            }
        }
    }
}