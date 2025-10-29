import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int N = board.length;
        int M = board[0].length;
        int[][] temp = new int[N+1][M+1];
        
        for(int i=0; i<skill.length; i++){
            int type = skill[i][0];
            int y1 = skill[i][1];
            int x1 = skill[i][2];
            int y2 = skill[i][3];
            int x2 = skill[i][4];
            int degree = skill[i][5];
            
            if(type == 1){
                doSkill(temp, y1, x1, y2, x2, degree * -1);
            } else if(type == 2){
                doSkill(temp, y1, x1, y2, x2, degree);
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=1; j<M; j++){
                temp[i][j] += temp[i][j-1];
            }
        }
        
        for(int i=0; i<M; i++){
            for(int j=1; j<N; j++){
                temp[j][i] += temp[j-1][i];
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                board[i][j] += temp[i][j];
                if(board[i][j] > 0)
                    answer++;
            }
        }
        
        // 기존의 1차원 배열에서의 누적합은 [l,r]에 n을 더할 때 arr[l] += n, arr[r+1] = -n
        // 맨 마지막에 누적합 계산 1번만 진행하기 
        
        // 이 문제는 2차원 배열에서의 누적합을 원한다.
        
        
        return answer;
    }
    
    public void doSkill(int[][] temp, int y1, int x1, int y2, int x2, int degree){
        temp[y1][x1] += degree;
        temp[y1][x2+1] -= degree;
        temp[y2+1][x1] -= degree;
        temp[y2+1][x2+1] += degree;
    }
}