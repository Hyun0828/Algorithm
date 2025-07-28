import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            Map<Character, Integer> map = getMap(skill_trees[i]);
            int num = -1;
            boolean isOk = true;
            boolean flag = false;

            for(int j=0; j<skill.length(); j++){
                Character c = skill.charAt(j);
                
                if(flag && map.containsKey(c)){
                    isOk = false;
                    break;
                }
                
                if(map.containsKey(c)) {
                    if(num > map.get(c)) {
                        isOk = false;
                        break;
                    } else {
                        num = map.get(c);
                    }
                } else {
                    if(j == skill.length() - 1) {
                        // 문제 없음
                    } else {
                        // 뒤에 나오는 모든 문자에 대해 값이 없어야 Ok
                        flag = true;
                    }
                } 
            }
            
            if(isOk){
                System.out.println(skill_trees[i]);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static Map<Character, Integer> getMap(String skill_tree){
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<skill_tree.length(); i++){
            map.put(skill_tree.charAt(i), i);
        }
        
        return map;
    }
}