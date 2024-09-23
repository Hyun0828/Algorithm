import java.util.*;

class Solution {
    
    Queue<Point> queue = new LinkedList<>();
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0){
                    int area = BFS(m, n, i, j, picture);
                    // 방문을 제대로 했다면
                    if(area > 0){
                        numberOfArea++;
                        maxSizeOfOneArea = Math.max(area, maxSizeOfOneArea);
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private int BFS(int m, int n, int cx, int cy, int[][] picture){
        
        int area = 0;
        int type = picture[cx][cy]; // 영역의 번호
        queue.add(new Point(cx, cy));
        
        while(!queue.isEmpty()){
            
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            
            // 이미 방문했거나 같은 영역이 아니라면
            if(visited[x][y] || picture[x][y] != type) continue;
            
            // 같은 영역이면 방문한다.
            visited[x][y] = true;
            picture[x][y] = 0;
            area++;
            
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx<0 || nx>=m || ny<0 || ny>=n) 
                    continue;
                
                queue.add(new Point(nx, ny));
            }
        }
        
        return area;
    }
}

class Point {
    int x;
    int y;
    
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}