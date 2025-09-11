import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        for(int i=0; i<completion.length; i++){
            if(map.containsKey(completion[i])){
                int num = map.get(completion[i]);
                if(num >= 2){
                    map.put(completion[i], map.get(completion[i]) - 1);
                } else {
                    map.remove(completion[i]);
                }
            }
        }
        
        for(String s : map.keySet()){
            answer = s;
        }
        
        return answer;
    }
}