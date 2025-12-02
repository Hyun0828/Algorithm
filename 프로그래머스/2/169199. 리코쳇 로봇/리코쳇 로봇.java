import java.util.*;

class Solution {
    
    char[][] map;
    int[][] dis;
    int N,M;
    int sy,ey,sx,ex;
    
    public int solution(String[] board) {
        int answer = 0;
        
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        for(int i=0; i<N; i++){
            map[i] = board[i].toCharArray();
            for(int j=0; j<M; j++){
                if(map[i][j] == 'R'){
                    sy = i;
                    sx = j;
                } else if(map[i][j] == 'G'){
                    ey = i;
                    ex = j;
                }
            }
        }
        bfs();
        return dis[ey][ex] > 0 ? dis[ey][ex] : -1;
    }
    
    public void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        dis = new int[N][M];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        queue.add(new int[]{sy, sx});
        visited[sy][sx] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            
            if(cy == ey && cx == ex){
                break;
            }
            
            for(int i=0; i<4; i++){
                int j=1;
                while(true){
                    int ny = cy + dy[i] * j;
                    int nx = cx + dx[i] * j;
                    
                    if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 'D'){
                        int ry = ny - dy[i];
                        int rx = nx - dx[i];

                        if (!visited[ry][rx]) {
                            visited[ry][rx] = true;
                            dis[ry][rx] = dis[cy][cx] + 1;
                            queue.add(new int[]{ry, rx});
                        }
                        break;
                    }
                    
                    j++;
                }
            }
        }
    }
}
