import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        
        for(char dir : dirs.toCharArray()){
            int dx = 0;
            int dy = 0;
            if(dir == 'L'){
                dx--;
            } else if (dir == 'R'){
                dx++;
            } else if (dir == 'U'){
                dy++;
            } else if (dir == 'D'){
                dy--;
            }
            
            int nx = x+dx;
            int ny = y+dy;
            
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5)
                continue;
            
            String path = x + "," + y + "," + nx + "," + ny;
            String rpath = nx + "," + ny + "," + x + "," + y;
            visited.add(path);
            visited.add(rpath);
            
            x = nx;
            y = ny;
        }
        
        
        return visited.size()/2;
    }
}
