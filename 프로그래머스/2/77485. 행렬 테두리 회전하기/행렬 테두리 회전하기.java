import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] map = new int[rows][columns];
        int num = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                map[i][j] = num++;
            }
        }
        
        int idx = 0;
        for(int i=0; i<queries.length; i++){
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            
            int min = rotate(x1, y1, x2, y2, map);
            answer[idx++] = min;
            // for(int x=0; x<rows; x++){
            //     for(int y=0; y<columns; y++){
            //         System.out.print(map[x][y] + ", ");
            //     }
            //     System.out.println();
            // }
        }
        
        
        return answer;
    }
    
    public static int rotate(int x1, int y1, int x2, int y2, int[][] map){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // x1 행
        int temp1 = map[x1][y2];
        for(int i=y2; i>y1; i--){
            map[x1][i] = map[x1][i-1];
        }
        
        // y2 열
        int temp2 = map[x2][y2];
        for(int i=x2; i>x1; i--){
            map[i][y2] = map[i-1][y2];
        }
        map[x1+1][y2] = temp1;        
        
        // x2 행
        temp1 = map[x2][y1];
        for(int i=y1; i<y2; i++){
            map[x2][i] = map[x2][i+1];
        }
        map[x2][y2-1] = temp2;
        
        // y1 열
        for(int i=x1; i<x2; i++){
            map[i][y1] = map[i+1][y1];
        }
        map[x2-1][y1] = temp1;
        
        for(int i=y1; i<=y2; i++){
            pq.offer(map[x1][i]);
        }
        for(int i=x1; i<=x2; i++){
            pq.offer(map[i][y2]);
        }
        for(int i=y1; i<=y2; i++){
            pq.offer(map[x2][i]);
        }
        for(int i=x1; i<=x2; i++){
            pq.offer(map[i][y1]);
        }
        return pq.peek();
    }
}