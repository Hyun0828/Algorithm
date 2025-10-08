import java.util.*;

class Solution {
    
    public int[] solution(int n) {
        int end = 0;
        for(int i=1; i<=n; i++)
            end += i;
        /*
            1
            2 12
            3 13 11
            4 14 15 10
            5  6  7  8  9
        */
        int[][] arr = new int[n][n];
        int y = 0;
        int x = 0;
        int num = 1;
        int dir = 1; // 아래 : 1, 오른쪽 : 2, 왼쪽 위 : 3
        
        while(true){
            if(dir == 1){
                arr[y][x] = num;
                y++;
                num++;
                
                if(y < 0 || y >= n || arr[y][x] != 0){
                    y--;
                    x++;
                    dir = 2;
                }
            } else if(dir == 2){
                arr[y][x] = num;
                x++;
                num++;
                
                if(x < 0 || x >= n || arr[y][x] != 0){
                    x--;
                    y--;
                    x--;
                    dir = 3;
                }
            } else if(dir == 3){
                arr[y][x] = num;
                y--;
                x--;
                num++;
                
                if(y < 0 || y >= n || x < 0 || x >= n || arr[y][x] != 0){
                    y++;
                    x++;
                    y++;
                    dir = 1;
                }
            }
            
            if(num > end)
                break;
        }
        
        
        int[] answer = new int[num-1];
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                answer[idx++] = arr[i][j];
            }
            System.out.println();
        }
        return answer;
    }
    
}