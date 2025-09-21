import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) { 
        
        int[][] map = new int[101][101];
        int[][] dist = new int[101][101];
        
        init(map, rectangle);
        bfs(dist, map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        return dist[itemY * 2][itemX * 2] / 2;
    }
    

    // 왼쪽 위, 오른쪽 아래 좌표
    public void init(int[][] map, int[][] rectangle){
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            for (int i = y1; i <= y2; i++) {
                for (int j = x1; j <= x2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int i = y1 + 1; i < y2; i++) {
                for (int j = x1 + 1; j < x2; j++) {
                    map[i][j] = 0;
                }
            }
        }
    }
    
    public void bfs(int[][] dist, int[][] map, int characterX, int characterY, int itemX, int itemY){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        queue.add(new int[]{characterY, characterX});
        visited[characterY][characterX] = true;
        dist[characterY][characterX] = 0;

        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int y = arr[0];
            int x = arr[1];
            
            if(y == itemY && x == itemX){
                break;
            }
            
            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= 101 || nx >= 101 || visited[ny][nx] || map[ny][nx] == 0)
                    continue;
                
                visited[ny][nx] = true;
                dist[ny][nx] = dist[y][x] + 1;
                queue.add(new int[]{ny, nx});
            }
        }
    }
}