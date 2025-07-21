import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int answer = BFS(n, m, maps);
        if(answer == 1){
            return -1;
        }
        return answer;
    }
    
    public static int BFS(int n, int m, int[][] maps){
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        
        queue.add(new Point(0, 0));
        
        while(!queue.isEmpty()){
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;
            
            if(visited[y][x])
                continue;
            
            visited[y][x] = true;
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 맵을 벗어나면
                if(ny < 0 || ny >= n || nx < 0 || nx >= m)
                    continue;
                
                // 벽이면
                if(maps[ny][nx] == 0)
                    continue;
                
                // 이미 방문했다면
                if(visited[ny][nx])
                    continue;
                
                queue.add(new Point(nx,ny));
                maps[ny][nx] = maps[y][x] + 1;
            }
        }
        
        return maps[n-1][m-1];
    }
    
    static class Point {
        int x;
        int y;
        
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}