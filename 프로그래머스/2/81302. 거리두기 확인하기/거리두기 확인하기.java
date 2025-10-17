import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++){
            String[] place = places[i];
            char[][] map = convert(place);
            List<int[]> points = getStartPoint(map);
            boolean isGood = true;
            for(int[] p : points){
                if(!check(map, p[0], p[1])){
                    isGood = false;
                } 
            }
            if(isGood)
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        
        return answer;
    }
    
    public boolean posCheck(int N, int M, int y, int x){
        if(y < 0 || x < 0 || y >= N || x >= M)
            return false;
        return true;
    }
    
    public boolean check(char[][] map, int y, int x){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int N = map.length;
        int M = map[0].length;
        
        // 1. 맨해튼 거리가 1일 때는 아예 이웃하면 안 됨
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(!posCheck(N, M, ny, nx))
                continue;
            if(map[ny][nx] == 'P'){
                return false;
            }
        }
        
        // 2. 맨해튼 거리가 2일 때
        if(posCheck(N, M, y-1, x-1) && (map[y-1][x] != 'X' || map[y][x-1] != 'X') && map[y-1][x-1] == 'P')
            return false;
        if(posCheck(N, M, y+1, x-1) && (map[y][x-1] != 'X' || map[y+1][x] != 'X') && map[y+1][x-1] == 'P')
            return false;
        if(posCheck(N, M, y-1, x+1) && (map[y][x+1] != 'X' || map[y-1][x] != 'X') && map[y-1][x+1] == 'P')
            return false;
        if(posCheck(N, M, y+1, x+1) && (map[y][x+1] != 'X' || map[y+1][x] != 'X') && map[y+1][x+1] == 'P')
            return false;
        
        for(int i=0; i<4; i++){
            int my = y + dy[i];
            int mx = x + dx[i];
            int ny = y + 2 * dy[i];
            int nx = x + 2 * dx[i];
            
            if(!posCheck(N, M, ny, nx))
                continue;
            if(map[my][mx] != 'X' && map[ny][nx] == 'P')
                return false;
        }
        return true;
    }
    
    public List<int[]> getStartPoint(char[][] map){
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == 'P'){
                    list.add(new int[]{i, j});
                }
            }
        }
        return list;
    }
    
    public char[][] convert(String[] place){
        char[][] map = new char[place.length][place[0].length()];
        for(int i=0; i<place.length; i++){
            map[i] = place[i].toCharArray();
        }
        return map;
    }
}