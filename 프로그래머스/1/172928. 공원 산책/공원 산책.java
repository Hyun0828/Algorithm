import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int H = park.length;
        int W = park[0].length();
        
        char[][] map = new char[H][W];
        int x = 0;
        int y = 0;
        
        for(int i=0; i<H; i++){
            map[i] = park[i].toCharArray();
            for(int j=0; j<W; j++){
                if(map[i][j] == 'S'){
                    x=i;
                    y=j;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++){
            String[] route = routes[i].split(" ");
            String op = route[0];
            int len = Integer.parseInt(route[1]);
            
            boolean flag = true;
            if(op.equals("E")){
                if(y + len >= W)
                    continue;
                for(int j=1; j<=len; j++){
                    if(map[x][y+j] == 'X')
                        flag = false;
                }
                if(flag)
                    y += len;
                
            } else if(op.equals("W")){
                if(y - len < 0)
                    continue;
                for(int j=1; j<=len; j++){
                    if(map[x][y-j] == 'X')
                        flag = false;
                }
                if(flag)
                    y -= len;
                
            } else if(op.equals("S")){
                if(x + len >= H)
                    continue;
                for(int j=1; j<=len; j++){
                    if(map[x+j][y] == 'X')
                        flag = false;
                }
                if(flag)
                    x += len;
                
            } else if(op.equals("N")){
                if(x - len < 0)
                    continue;
                for(int j=1; j<=len; j++)
                    if(map[x-j][y] == 'X')
                        flag = false;
                if(flag)
                    x -= len;
            }
        }
        
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}