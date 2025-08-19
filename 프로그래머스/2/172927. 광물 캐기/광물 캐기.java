import java.util.*;

class Solution {
    
    static int min = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        // 1. 광물은 무조건 순서대로 캐야한다.
        // 2. 곡괭이를 다 쓰거나, 전부 캐면 끝난다.
        // 피로도가 가장 적으려면, 광물이 단단할수록 강한 곡괭이를 써야 한다.
        
        // 곡괭이를 선택하면, 5개는 무조건 캐야되잖아
        
        int[][] piro = new int[3][(minerals.length - 1) / 5 + 1];
        int idx = 0;
        for(int i=0; i<minerals.length; i+=5){
            for(int j=i; j<Math.min(minerals.length, i+5); j++){
                String s = minerals[j];
                if(s.equals("diamond")){
                    piro[0][idx] += 1;
                    piro[1][idx] += 5;
                    piro[2][idx] += 25;
                } else if(s.equals("iron")){
                    piro[0][idx] += 1;
                    piro[1][idx] += 1;
                    piro[2][idx] += 5;
                } else if(s.equals("stone")){
                    piro[0][idx] += 1;
                    piro[1][idx] += 1;
                    piro[2][idx] += 1;
                }   
            }
            idx++;
        }
        
        dfs(picks, piro, 0, 0);
        
        return min;
    }
    
    // 5 3
    // 17 7
    // 85 31

    // 5   5  1
    // 25  5  5
    // 125 25 25
    
    public static void dfs(int[] picks, int[][] piro, int value, int idx){
        if(min <= value)
            return;
        
        if(idx == piro[0].length || isEmpty(picks)){
            min = Math.min(min, value);
            return;
        }
        
        for(int i=0; i<3; i++){
            if(picks[i] > 0){
                picks[i] -= 1;
                dfs(picks, piro, value + piro[i][idx], idx + 1);
                picks[i] += 1;
            }
        }
    }
    
    public static boolean isEmpty(int[] picks){
        for(int i=0; i<3; i++){
            if(picks[i] != 0)
                return false;
        }
        return true;
    }
}
