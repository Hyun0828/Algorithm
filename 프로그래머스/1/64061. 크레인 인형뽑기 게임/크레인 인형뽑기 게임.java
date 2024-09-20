import java.util.*; 

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<moves.length; i++){
            int move = moves[i];
            int doll = 0;
            for(int j=0; j<board.length; j++){
                // 가장 위에 있는 인형을 집어서 옮긴다.
                if(board[j][move-1] != 0){
                    doll = board[j][move-1];
                    board[j][move-1] = 0;
                    break;
                }
            }
            
            if(doll!=0){
                if(!stack.isEmpty()){
                    if(doll == stack.peek()){
                        stack.pop();
                        answer += 2;
                    } else{
                        stack.push(doll);
                    }
                } else{
                    stack.push(doll);
                }    
            }
            
        }
        
        return answer;
    }
}