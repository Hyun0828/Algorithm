import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 완탐은 2^500이니까 당연히 안 되겠지
        // DP가 가능할까? save and reuse의 관점에서 바라보면, 아래로 내려올 때는 위에서 최댓값에 현재 값을 더해주면 된다.
        
        // 7
        // 3 8
        // 8 1 0
        // 2 7 4 4
        // 4 5 2 6 5
        
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j==0){
                    triangle[i][j] = triangle[i-1][j] + triangle[i][j];
                } else if(j==triangle[i].length-1){
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i][j];
                } else {
                    triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        for(int i=0; i<triangle[triangle.length-1].length; i++){
            answer = Math.max(triangle[triangle.length-1][i], answer);
        }
        
        return answer;
    }
}