import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        String[] ans = new String[players.length];
        Map<String, Integer> answer = new HashMap<>();
        Map<Integer, String> idx = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            answer.put(players[i], i);
            idx.put(i, players[i]);
        }
        
        for(int i=0; i<callings.length; i++){
            int index = answer.get(callings[i]); // 4
            String person = idx.get(index-1); // poe
            
            answer.put(person, answer.getOrDefault(person, 0) + 1);
            answer.put(callings[i], answer.getOrDefault(callings[i], 0) - 1);
            
            idx.put(index-1, callings[i]);
            idx.put(index, person);
        }
        
        for(int i=0; i<idx.size(); i++){
            String person = idx.get(i);
            ans[i] = person;
        }
        
        return ans;
    }
}