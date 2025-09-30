import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){
                if(j==0)
                    land[i][j] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
                else if(j==1)
                    land[i][j] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
                else if(j==2)
                    land[i][j] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
                else if(j==3)
                    land[i][j] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][0]);
            }
        }
        
        for(int i=0; i<4; i++){
            answer = Math.max(answer, land[land.length-1][i]);
        }

        return answer;
    }
}