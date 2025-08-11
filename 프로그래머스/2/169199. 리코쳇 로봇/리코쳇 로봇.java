import java.util.*;

class Solution {
    public int solution(String[] board) {
        int Y = board.length;
        int X = board[0].length();
        
        int[][] map = new int[Y][X];
        int[][] dis = new int[Y][X];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        
        for(int i=0; i<Y; i++){
            Arrays.fill(dis[i], 10000000);
        }
        
        for(int i=0; i<board.length; i++){
            char[] arr = board[i].toCharArray();
            for(int j=0; j<arr.length; j++){
                if(arr[j] == 'R'){
                    startY = i;
                    startX = j;
                } else if(arr[j] == 'D'){
                    map[i][j] = 1;
                } else if(arr[j] == 'G'){
                    endY = i;
                    endX = j;
                    map[i][j] = 2;
                }
            }
        }
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startY, startX, 0));
        
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int currentY = point.y;
            int currentX = point.x;
            int currentDis = point.dis;
            
            if(map[currentY][currentX] == 2)
                return dis[currentY][currentX];
            
            // 좌 우 상 하
            for(int i=0; i<4; i++){
                int nY = currentY;
                int nX = currentX;
                
                while(nY + dy[i] >= 0 && nY + dy[i] < Y && nX + dx[i] >= 0 && nX + dx[i] < X && map[nY+dy[i]][nX+dx[i]] != 1){
                    nY += dy[i];
                    nX += dx[i];
                }
                
                if(dis[nY][nX] > currentDis + 1){
                    dis[nY][nX] = currentDis + 1;
                    queue.add(new Point(nY, nX, dis[nY][nX]));
                }
            }
        }
        
        
        return -1;
    }
    
    public static class Point {
        int y;
        int x;
        int dis;
        
        public Point(int y, int x, int dis){
            this.y=y;
            this.x=x;
            this.dis=dis;
        }
    }
}