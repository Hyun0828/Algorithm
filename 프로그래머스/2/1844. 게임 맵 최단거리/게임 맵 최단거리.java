import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int h = maps.length;
        int w = maps[0].length;
        return bfs(w, h, maps);
    }
    
    public int bfs(int w, int h, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        queue.add(new int[]{0,0});
        // visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            
            if(cy == h-1 && cx == w-1)
                break;
            
            if(visited[cy][cx])
                continue;
            visited[cy][cx] = true;
            
            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                if(ny < 0 || ny >= h || nx < 0 || nx >= w || visited[ny][nx] || maps[ny][nx] == 0)
                    continue;
                
                maps[ny][nx] = maps[cy][cx] + 1;
                queue.add(new int[]{ny, nx});
            }
        }
        
        if(maps[h-1][w-1] == 1)
            return -1;
        return maps[h-1][w-1];
    }
}