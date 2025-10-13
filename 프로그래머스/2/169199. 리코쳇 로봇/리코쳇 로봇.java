import java.util.*;

class Solution {
    
    int answer = 0;
    int N;
    int M;
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        char[][] map = new char[N][M];
        int sy = 0;
        int sx = 0;
        int ey = 0;
        int ex = 0;
        
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
        
        bfs(map, sy, sx, ey, ex);
        
        return answer > 0 ? answer : -1;
    }
    
    public void bfs(char[][] map, int sy, int sx, int ey, int ex){
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        queue.add(new int[]{sy, sx, 0});
        visited.add(sy + "," + sx);
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            int cd = cur[2];
                        
            if(cy == ey && cx == ex){
                answer = cd;
                break;
            }
            
            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                int nd = cd + 1;
                
                while(true){
                    if(ny < 0 || nx < 0 || ny >= N || nx >= M)
                        break;
                        
                    if(map[ny][nx] == 'D'){
                        break;
                    }
                    
                    int ay = ny + dy[i];
                    int ax = nx + dx[i];
                    if(ay < 0 || ax < 0 || ay >= N || ax >= M || map[ay][ax] == 'D'){
                        if(visited.contains(ny + "," + nx)){
                            break;
                        }
                        visited.add(ny + "," + nx);
                        queue.add(new int[]{ny, nx, nd});
                        break;
                    }
                    
                    ny += dy[i];
                    nx += dx[i];
                }
            }
        }
    }
}