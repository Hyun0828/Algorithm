import java.util.*;

class Solution {
    
    Set<Set<Integer>> result = new HashSet<>();
    
    public int solution(String[][] relation) {        
        int col = relation[0].length;
        for(int i=1; i<=col; i++)
            dfs(relation, new HashSet<>(), 0, col, i);
        return result.size();
    }
    
    // 유일성 만족 여부
    public boolean mini(String[][] relation, Set<Integer> set){
        Set<String> temp = new HashSet<>();
        for(int i=0; i<relation.length; i++){
            String s = "";
            for(Integer key : set){
                s += relation[i][key];
            }
            temp.add(s);
        }
        
        return temp.size() == relation.length;
    }
    
    // 최소성
    public boolean uniq(Set<Integer> set){
        for(Set<Integer> temp : result){
            if(set.containsAll(temp))
                return false;
        }
        return true;
    }

    public void dfs(String[][] relation, Set<Integer> set, int start, int col, int n){
        if(set.size() == n){
            if(uniq(new HashSet<>(set)) && mini(relation, set)){
                System.out.println(set);
                result.add(set);
            }
            return;
        }
        
        for(int i=start; i<col; i++){
            set.add(i);
            dfs(relation, new HashSet<>(set), i+1, col, n);
            set.remove(i);
        }
    }
}