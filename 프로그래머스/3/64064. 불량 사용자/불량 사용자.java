import java.util.*;

class Solution {
    
    Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {        
        dfs(user_id, banned_id, new HashSet<>(), 0);
        return result.size();
    }
    
    public boolean check(String user, String ban){
        if(user.length() != ban.length())
            return false;
        
        for(int i=0; i<user.length(); i++){
            if(ban.charAt(i) != '*' && user.charAt(i) != ban.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
    
    public void dfs(String[] user_id, String[] banned_id, Set<String> set, int idx){
        if(idx == banned_id.length){
            result.add(set);
            return;
        }
        
        for(int i=0; i<user_id.length; i++){
            if(set.contains(user_id[i]))
                continue;
            
            if(check(user_id[i], banned_id[idx])){
                set.add(user_id[i]);
                dfs(user_id, banned_id, new HashSet<>(set), idx + 1);
                set.remove(user_id[i]);
            }
        }
    }
}