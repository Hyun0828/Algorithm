import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            if(isOk(skill, skill_trees[i]))
                answer++;
        }
        
        return answer;
    }
    
    public boolean isOk(String skill, String skill_tree){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<skill.length(); i++){
            char c = skill.charAt(i);
            int index = skill_tree.indexOf(c);
            if(index == -1)
                list.add(100);
            else
                list.add(index);
        }
        int idx = list.get(0);
        for(int i=1; i<list.size(); i++){
            if(idx > list.get(i))
                return false;
            idx = list.get(i);
        }
        return true;
    }
}