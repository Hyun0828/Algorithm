import java.util.*;

class Solution {
    public int solution(String[] maps) {        
        int Y = maps.length;
        int X = maps[0].length();
        
        int sy = 0;
        int sx = 0;
        int ly = 0;
        int lx = 0;
        int ey = 0;
        int ex = 0;
        
        char[][] map = new char[Y][X];
        for(int i=0; i<Y; i++){
            map[i] = maps[i].toCharArray();
            for(int j=0; j<X; j++){
                if(map[i][j] == 'S'){
                    sy = i;
                    sx = j;
                } else if(map[i][j] == 'L'){
                    ly = i;
                    lx = j;
                } else if(map[i][j] == 'E'){
                    ey = i;
                    ex = j;
                }
            }
        }
        
        int l1 = bfs(map, Y, X, sy, sx, ly, lx);
        if(l1 == -1)
            return -1;
        int l2 = bfs(map, Y, X, ly, lx, ey, ex);
        if(l2 == -1)
            return -1;
        return l1 + l2;
    }
    
    public int bfs(char[][] map, int Y, int X, int sy, int sx, int ey, int ex){
        Queue<int[]> queue = new LinkedList<>(); // y, x, len
        Set<String> visited = new HashSet<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        queue.add(new int[]{sy, sx, 0});
        visited.add(sy + "," + sx);
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            int cLen = cur[2];
            
            if(cy == ey && cx == ex){
                return cLen;
            }
            
            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                int nLen = cLen + 1;
                
                if(ny < 0 || ny >= Y || nx < 0 || nx >= X || map[ny][nx] == 'X' || visited.contains(ny + "," + nx))
                    continue;
                
                visited.add(ny + "," + nx);
                queue.add(new int[]{ny, nx, nLen});
            }
        }
        
        return -1;
    }
}