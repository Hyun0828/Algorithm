import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;    
        int[][][] map = new int[4][n][n]; // 방향별 최솟값을 저장한다.
        for (int i = 0; i < 4; i++) map[i][0][0] = 0;
        bfs(n, map, board);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (map[i][n-1][n-1] != 0)
                answer = Math.min(answer, map[i][n-1][n-1]);
        }
        return answer;
        
        /*
            0 0 0 0 0
            0 1 1 1 0
            0 0 1 0 0
            1 0 0 0 1
            1 1 1 0 0
        */
    }
    
    public void bfs(int n, int[][][] map, int[][] board){
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        queue.add(new int[]{0,0,0,4});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            int cd = cur[2];
            int cdir = cur[3];
            
            // 0123 : 좌우하상
            for(int i=0; i<4; i++){
                int add = 0;
                if(cdir == i || cdir == 4){
                    add = 100;
                } else {
                    add = 600;
                }
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                int nd = cd + add;
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= n)
                    continue;
                if(board[ny][nx] == 1)
                    continue;
                
                if(map[i][ny][nx] == 0 || map[i][ny][nx] >= nd){
                    map[i][ny][nx] = nd;
                    queue.add(new int[]{ny,nx,nd,i});
                }
            }
        }
    }
}