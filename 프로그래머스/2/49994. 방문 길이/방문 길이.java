import java.util.*;

class Solution {
    public int solution(String dirs) {
        int cy = 0;
        int cx = 0;
        Set<String> visited = new HashSet<>();
        
        for(int i=0; i<dirs.length(); i++){
            char c = dirs.charAt(i);
            
            if(c == 'U') {
                int ny = cy + 1;
                int nx = cx;
                if(check(ny, nx)){
                    String s1 = cy + "," + cx + "," + ny + "," + nx;   
                    String s2 = ny + "," + nx + "," + cy + "," + cx;
                    visited.add(s1);
                    visited.add(s2);
                    cy = ny;
                    cx = nx;
                }
            } else if(c == 'D'){
                int ny = cy - 1;
                int nx = cx;
                if(check(ny, nx)){
                    String s1 = cy + "," + cx + "," + ny + "," + nx;   
                    String s2 = ny + "," + nx + "," + cy + "," + cx;
                    visited.add(s1);
                    visited.add(s2);
                    cy = ny;
                    cx = nx;
                } 
            } else if(c == 'R'){
                int ny = cy;
                int nx = cx + 1;
                if(check(ny, nx)){
                    String s1 = cy + "," + cx + "," + ny + "," + nx;   
                    String s2 = ny + "," + nx + "," + cy + "," + cx;
                    visited.add(s1);
                    visited.add(s2);
                    cy = ny;
                    cx = nx;
                }
            } else if(c == 'L'){
                int ny = cy;
                int nx = cx - 1;
                if(check(ny, nx)){
                    String s1 = cy + "," + cx + "," + ny + "," + nx;   
                    String s2 = ny + "," + nx + "," + cy + "," + cx;
                    visited.add(s1);
                    visited.add(s2);
                    cy = ny;
                    cx = nx;
                }
            }
        }
        
        return visited.size() / 2;
    }
    
    public boolean check(int y, int x){
        if(y < -5 || y > 5 || x < -5 || x > 5)
            return false;
        return true;
    }
}