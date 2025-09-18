import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<reserve.length; i++){
            set.add(reserve[i]);
        }
        
        for(int i=0; i<lost.length; i++){
            if(set.contains(lost[i])){
                set.remove(lost[i]);
                lost[i] = 0;
                answer++;
            }
        }
        
        for(int i=0; i<lost.length; i++){
            if(lost[i] == 1){
                if(set.contains(2)){
                    set.remove(2);
                    answer++;
                }
            } else if(lost[i] >= 2){
                if(set.contains(lost[i]-1)){
                    set.remove(lost[i]-1);
                    answer++;
                } else if(set.contains(lost[i] + 1)){
                    set.remove(lost[i]+1);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}