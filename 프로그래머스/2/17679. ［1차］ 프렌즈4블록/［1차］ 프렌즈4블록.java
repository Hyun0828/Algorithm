import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] map = new char[m][n];
        for(int i=0; i<board.length; i++){
            map[i] = board[i].toCharArray();
        }
        
        while(true){
            // 찾고
            Set<String> points = search(m, n, map);
            if(points.isEmpty()){
                break;
            }
            answer += points.size();
            
            // 없애고
            delete(points, m, n, map);

            // 내리고
            down(m, n, map);
        }
        return answer;
    }
    
    public static Set<String> search(int m, int n, char[][] map){
        Set<String> points = new HashSet<>();
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                char c = map[i][j];
                if(c == '0')
                    continue;
                if(map[i+1][j] == c && map[i][j+1] == c && map[i+1][j+1] == c){
                    points.add(i + "," + j);
                    points.add((i+1) + "," + j);
                    points.add(i +"," +(j+1));
                    points.add((i+1)+","+(j+1));
                }
            }
        }
        
        return points;
    }
    
    public static void delete(Set<String> points, int m, int n, char[][] map){
        for(String p : points){
            int x = Integer.parseInt(p.split(",")[1]);
            int y = Integer.parseInt(p.split(",")[0]);
            map[y][x] = '0';
        }
    }
    
    public static void down(int m, int n, char[][] map){
        for (int i=m-1; i>0; i--) {
            for(int j=0; j<n; j++){
                if(map[i][j] == '0'){
                    int k = i - 1;
                    while(k >= 0 && map[k][j] == '0')
                        k--;
                    if(k >= 0){
                        map[i][j] = map[k][j];
                        map[k][j] = '0';
                    }
                }
            }
        }
    }
    
    static class Point {
        int y;
        int x;
        
        public Point(int y, int x){
            this.x=x;
            this.y=y;
        }
    }
}