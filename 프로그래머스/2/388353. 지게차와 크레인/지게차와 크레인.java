import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] storage, String[] requests) {
        int Y = storage.length;
        int X = storage[0].length();
        char[][] map = new char[Y+2][X+2];
        int answer = Y * X;
        
        for(int i=1; i<=Y; i++){
            String s = storage[i-1];
            for(int j=1; j<=X; j++){
                map[i][j] = s.charAt(j-1);
            }
        }
        
        for(int i=0; i<=X+1; i++){
            map[0][i] = 'o';   
            map[Y+1][i] = 'o';
        }
        for(int i=0; i<=Y+1; i++){
            map[i][0] = 'o';   
            map[i][X+1] = 'o';
        }
                   
        
        for(int i=0; i<requests.length; i++){
            if(requests[i].length() == 1)
                use1(Y, X, map, requests[i].charAt(0));
            else if(requests[i].length() == 2)
                use2(Y, X, map, requests[i].charAt(0));
        }
        
        for(int i=1; i<=Y; i++){
            for(int j=1; j<=X; j++){
                if(map[i][j] == 'o')
                    answer--;
            }
        }
        
        return answer;
    }
    
    public static void use1(int Y, int X, char[][] map, char target){
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[Y+2][X+2];
        Queue<Point> q = new LinkedList<>();
        
        queue.add(new Point(0, 0));
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            
            if(visited[p.y][p.x])
                continue;
            visited[p.y][p.x] = true;
            
            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                
                if(ny < 0 || ny > Y + 1 || nx < 0 || nx > X + 1)
                    continue;
                
                if(visited[ny][nx])
                    continue;
                
                if(map[ny][nx] == target){
                    q.add(new Point(ny, nx));
                }
                
                if(map[ny][nx] != 'o')
                    continue;
                
                queue.add(new Point(ny, nx));
            }
        }
        
        while(!q.isEmpty()){
            Point p = q.poll();
            map[p.y][p.x] = 'o';
        }
    }
    
    public static void use2(int Y, int X, char[][] map, char target){
        for(int i=1; i<=Y; i++){
            for(int j=1; j<=X; j++){
                if(map[i][j] == target){
                    map[i][j] = 'o';
                }
            }
        }
    }
    
    public static class Point {
        int y;
        int x;
        
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}