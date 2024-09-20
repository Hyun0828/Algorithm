import java.util.*;

// 1-2-3-1
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> hamb = new LinkedList<>();
    
        for(int i=0; i<ingredient.length; i++){
            int ing = ingredient[i];
            
            hamb.add(ing);
            
            // 1-2-3-1 check
            if(hamb.size() >= 4){
                int end = hamb.size()-1;
                if(hamb.get(end)==1 && hamb.get(end-1)==3 && hamb.get(end-2)==2 && hamb.get(end-3)==1){
                    for(int j=0; j<4; j++)
                        hamb.remove(hamb.size()-1);
                    answer++;
                }
            }
        }        
        
        return answer;
    }
}