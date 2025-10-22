import java.util.*;

class Solution {
    List<int[]> result = new ArrayList<>();
    
    public int[][] solution(int n) {
        int m = (int) Math.pow(2, n) - 1;
        int[][] answer = new int[m][2];
        hanoi(n, 1, 2, 3);
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public void hanoi(int n, int a, int b, int c){
        if(n == 1){
            result.add(new int[]{a, c});
            return;
        }   
        
        hanoi(n-1, a, c, b);
        hanoi(1, a, b, c);
        hanoi(n-1, b, a, c);
    }
}