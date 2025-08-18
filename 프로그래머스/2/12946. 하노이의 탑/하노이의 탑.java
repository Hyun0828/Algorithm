import java.util.*;

class Solution {
    
    static List<Temp> result;
        
    public int[][] solution(int n) {
        result = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[result.size()][2];
        for(int i=0; i<result.size(); i++){
            answer[i][0] = result.get(i).from;
            answer[i][1] = result.get(i).to;
        }
        
        return answer;
    }
    
    public static void hanoi(int n, int a, int b, int c){
        if(n == 1) {
            result.add(new Temp(a, c));
            return;
        }
        
        hanoi(n-1, a, c, b);
        hanoi(1, a, b, c);
        hanoi(n-1, b, a, c);
    }
    
    static class Temp {
        int from;
        int to;
        
        public Temp(int from, int to){
            this.from = from;
            this.to = to;
        }
    }
}