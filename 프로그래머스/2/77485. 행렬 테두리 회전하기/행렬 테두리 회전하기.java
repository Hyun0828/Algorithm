import java.util.*;

class Solution {
    
    int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int n = 1;
        map = new int[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                map[i][j] = n++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            int y1 = queries[i][0] - 1;
            int x1 = queries[i][1] - 1;
            int y2 = queries[i][2] - 1;
            int x2 = queries[i][3] - 1;
            
            answer[i] = rotate(y1,x1,y2,x2);
        }
        
        return answer;
    }
    
    public int rotate(int y1, int x1, int y2, int x2){
        int min = 100000000;
        int temp = map[y1][x1];
        
        // 왼쪽 -> 위
        for (int y = y1; y < y2; y++) {
            map[y][x1] = map[y + 1][x1];
            min = Math.min(min, map[y][x1]);
        }

        // 아래 -> 왼쪽
        for (int x = x1; x < x2; x++) {
            map[y2][x] = map[y2][x + 1];
            min = Math.min(min, map[y2][x]);
        }

        // 오른쪽 -> 아래
        for (int y = y2; y > y1; y--) {
            map[y][x2] = map[y - 1][x2];
            min = Math.min(min, map[y][x2]);
        }

        // 위 -> 오른쪽
        for (int x = x2; x > x1 + 1; x--) {
            map[y1][x] = map[y1][x - 1];
            min = Math.min(min, map[y1][x]);
        }
        
        map[y1][x1 + 1] = temp;

        return Math.min(min, temp);
    }
}