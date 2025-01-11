import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> counts = new HashMap<>();
        for(int tang : tangerine){
            counts.put(tang, counts.getOrDefault(tang, 0) + 1);
        }
        List<Integer> sortedCounts = new ArrayList<>(counts.values());
        sortedCounts.sort((a,b) -> b-a);
        
        for(int tang : sortedCounts){
            if(tang >= k){
                answer++;
                break;
            } else {
                answer++;
                k -= tang;
            }
        }
        
        return answer;
    }
}

class Type{
    int size;
    int count;
    
    public Type(int size, int count){
        this.size=size;
        this.count=count;
    }
}