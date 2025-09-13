import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int[] command = commands[i];
            int s = command[0];
            int e = command[1];
            int k = command[2];
            
            int[] tmp = new int[e-s+1];
            for(int j=s-1; j<e; j++){
                tmp[j-s+1] = array[j];
            }
            
            Arrays.sort(tmp);
            answer[i] = tmp[k-1];
        }
        
        return answer;
    }
}