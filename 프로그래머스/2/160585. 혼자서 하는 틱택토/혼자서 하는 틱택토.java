import java.util.*;

class Solution {
    public int solution(String[] board) {
        char[][] map = convert(board);
        int Y = map.length;
        int X = map[0].length;
        
        if(!countOX(map)){
            return 0;
        }
        
        return 1;
        // 규칙을 못 지킨 경우
        // 1. 'O'의 개수 = 'X'의 개수 or 'X'의 개수 + 1 여야 한다.
        // 2. 한 줄이 완성된 O나 X가 둘다 있을 때
        // 3. O나 X가 여러 줄 있을 때
        // 2,3번은 결국 O나 X가 한 줄만 있을 때를 의미한다.
        
        // 4. 근데 한 번에 2개의 빙고를 만들 때가 있다. 오,,,
        // 5. 한 번에 3개의 빙고는 불가능하다.
    }
    
    public char[][] convert(String[] board){
        char[][] map = new char[board.length][board[0].length()];
        for(int i=0; i<map.length; i++){
            map[i] = board[i].toCharArray();
        }
        return map;
    }
    
    public boolean countOX(char[][] board){
        int O=0;
        int X=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == 'O')
                    O++;
                else if(board[i][j] == 'X')
                    X++;
            }
        }
        
        int[] arr = check(board);
        if(O==X){
            if(arr[0] == 0)
                return true;
        } else if(O==X+1){
            if(arr[1] == 0)
                return true;
        }
        return false;
    }
    
    public int[] check(char[][] board){
        int O=0;
        int X=0;
        
        for(int i=0; i<3; i++){
            if(board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O')
                O++;
            if(board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X')
                X++;
        }
        
        for(int i=0; i<3; i++){
            if(board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O')
                O++;
            if(board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X')
                X++;
        }
        
        if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
            O++;
        if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
            X++;
        
        if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
            O++;
        if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
            X++;
        
        int[] arr = new int[2];
        arr[0] = O;
        arr[1] = X;
        return arr;
    }
}