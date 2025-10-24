import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {        
        int[][] arr = new int[3][(minerals.length + 4) / 5];
        int idx = 0;
        for(int i=0; i<minerals.length; i+=5){
            int dSum = 0;
            int iSum = 0;
            int sSum = 0;
            for(int j=i; j<minerals.length && j<i+5; j++){
                if(minerals[j].equals("diamond")){
                    dSum += 1;
                    iSum += 5;
                    sSum += 25;
                } else if(minerals[j].equals("iron")){
                    dSum += 1;
                    iSum += 1;
                    sSum += 5;
                } else {
                    dSum += 1;
                    iSum += 1;
                    sSum += 1;
                }
            }
            arr[0][idx] = dSum;
            arr[1][idx] = iSum;
            arr[2][idx] = sSum;
            idx++;
        }
        dfs(picks, arr, 0, 0);
        
        return answer;
    }
    
    // 5  3
    // 17 7
    // 85 31
    
    public void dfs(int[] picks, int[][] arr, int cost, int idx){
        if(cost >= answer){
            return;
        }
        
        if(isEmpty(picks) || idx == arr[0].length){
            answer = Math.min(answer, cost);
            return;
        }
       
        for(int i=0; i<3; i++){
            if(picks[i] <= 0)
                continue;
            picks[i]-=1;
            dfs(picks, arr, cost+arr[i][idx], idx + 1);
            picks[i]+=1;
        }
    }
    
    public boolean isEmpty(int[] picks){
        for(int i=0; i<3; i++){
            if(picks[i] > 0)
                return false;
        }
        return true;
    }
}