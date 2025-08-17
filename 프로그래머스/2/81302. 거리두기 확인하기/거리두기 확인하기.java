import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0; i<5; i++){
            answer[i] = 1;
        }
        
        for(int i=0; i<places.length; i++){
            String[] place = places[i];
            char[][] map = new char[5][5];
            Set<Point> set = new HashSet<>();
            
            for(int j=0; j<place.length; j++){
                map[j] = place[j].toCharArray();
            }
            
            // P 위치 찾기
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(map[j][k] == 'P')
                        set.add(new Point(j, k));
                }
            }
            
            // 각 P마다 확인
            for(Point p : set){
                int y = p.y;
                int x = p.x;
                
                if(!check(map, y, x)){
                    answer[i] = 0;
                    break;
                }
            }
        }    
        
        return answer;
    }
    
    public boolean check(char[][] map, int y, int x){
        // 좌 우 상 하
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
      
        // 1. 상하좌우 이웃 : 거리 1 -> 무조건 안 됨
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
                continue;
            
            if(map[ny][nx] == 'P')
                return false;
        }
        
        // 2. 대각선 이웃 : 거리 2 -> 확인해야
        int[] cx = {-1, -1, 1, 1};
        int[] cy = {-1, 1, -1, 1};
        for(int i=0; i<4; i++){
            int ny = y + cy[i];
            int nx = x + cx[i];
            
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
                continue;
            
            if(map[ny][nx] == 'P'){
                if(map[y][nx] != 'X' || map[ny][x] != 'X')
                    return false;
            }
        }
        
        // 3. 상하좌우 2 : 거리 2 -> 확인해야
        for(int i=0; i<4; i++){
            int ny = y + dy[i] * 2;
            int nx = x + dx[i] * 2;
            
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
                continue;
            
            if(map[ny][nx] == 'P'){
                if(i==0 && map[ny][x-1] != 'X')
                    return false;
                if(i==1 && map[ny][x+1] != 'X')
                    return false;
                if(i==2 && map[y-1][nx] != 'X')
                    return false;
                if(i==3 && map[y+1][nx] != 'X')
                    return false;
            }
        }
        
        return true;
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