import java.util.*;

class Solution {
    public int solution(String[] board) {
        char[][] map = new char[3][3];
        for(int i=0; i<3; i++){
            map[i] = board[i].toCharArray();
        }
        
        // 1. O의 개수 < X의 개수 거나 1개 이상 차이날 때
        int countO = 0;
        int countX = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(map[i][j] == 'O')
                    countO++;
                else if(map[i][j] == 'X')
                    countX++;
            }
        }
        
        if(countO < countX)
            return 0;
        if(countO - countX > 1)
            return 0;
        
        int lineO = hasLine(map, 'O');
        int lineX = hasLine(map, 'X');
        
        // 2. O와 X가 둘다 완성되었을 때
        if(lineO > 0 && lineX > 0)
            return 0;
        
        if(lineO > 0 && countO == countX)
            return 0;
        if(lineX > 0 && countO > countX)
            return 0;
        
        return 1;
    }
    
    public int hasLine(char[][] map, char c){
        int line = 0;
        for(int i=0; i<3; i++){
            if(map[0][i] == c && map[1][i] == c && map[2][i] == c)
                line++;
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c)
                line++;
        }
        
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c)
            line++;
        if(map[0][2] == c && map[1][1] == c && map[2][0] == c)
            line++;
        
        return line;
    }
}