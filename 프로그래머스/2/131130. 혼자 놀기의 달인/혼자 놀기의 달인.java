import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        Set<Set<Integer>> groups = new HashSet<>();
        
        for(int i=0; i<cards.length; i++){
            Set<Integer> group = open(cards, i);
            groups.add(group);
        }
        
        if(groups.size() == 1)
            return 0;
        
        List<Integer> temp = new ArrayList<>();
        for(Set<Integer> group : groups){
            temp.add(group.size());
        }
        Collections.sort(temp);
        
        return temp.get(temp.size()-1) * temp.get(temp.size()-2);
    }
    
    public Set<Integer> open(int[] cards, int cur){
        Set<Integer> visited = new HashSet<>(); // 그룹
        int idx = cur;
        while(!visited.contains(idx+1)){
            visited.add(idx+1);
            idx = cards[idx] - 1;
        }
        
        return visited;
    }
}

