import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i=0; i<gems.length; i++)
            set.add(gems[i]);
        int gemType = set.size();
        
        while(right < gems.length){
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            right++;
            
            while(map.size() == gemType){
                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                    end = right;
                }
                
                map.put(gems[left], map.get(gems[left]) - 1);
                if(map.get(gems[left]) == 0)
                    map.remove(gems[left]);
                left++;
            }
        }
        
        return new int[]{start+1, end};
    }
}