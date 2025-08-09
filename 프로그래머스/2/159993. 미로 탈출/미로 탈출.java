import java.util.*;

class Solution {
    
    static int[][] map;
    static int y;
    static int x;
    static Point start;
    static Point exit;
    static Point lev;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        y = maps.length;
        x = maps[0].length();
            
        init(maps);
        int dist1 = BFS(start, lev);
        if(dist1 == -1) return -1;

        init(maps);
        int dist2 = BFS(lev, exit);
        if(dist2 == -1) return -1;

        return dist1 + dist2;
    }
    
    public static void init(String[] maps){
        map = new int[y][x];
        for(int i=0; i<y; i++){
            char[] arr = maps[i].toCharArray();
            for(int j=0; j<x; j++){
                if(arr[j] == 'S'){
                    map[i][j] = 0;
                    start = new Point(i, j);
                } else if (arr[j] == 'X'){
                    map[i][j] = -1;
                } else if (arr[j] == 'O'){
                    map[i][j] = 0;
                } else if (arr[j] == 'E'){
                    map[i][j] = 0;
                    exit = new Point(i, j);
                } else if (arr[j] == 'L'){
                    map[i][j] = 0;
                    lev = new Point(i, j);
                }
            }
        }
    }
    
    public static int BFS(Point s, Point e){
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[y][x];
        
        queue.add(s);
        visited[s.y][s.x] = true;
        
        while(!queue.isEmpty()){
            Point current = queue.poll();
            int cy = current.y;
            int cx = current.x;
            int value = map[cy][cx];
            
            if(cy == e.y && cx == e.x){
                return map[cy][cx];
            }
            
            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                if(ny < 0 || ny >= y || nx < 0 || nx >= x)
                    continue;
                if(visited[ny][nx])
                    continue;
                if(map[ny][nx] == -1)
                    continue;
                
                visited[ny][nx] = true;
                queue.add(new Point(ny, nx));
                map[ny][nx] = value + 1;
            }
        }
        
        // 실패
        return -1;
    }
    
    static class Point {
        int y;
        int x;
        
        public Point(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
}