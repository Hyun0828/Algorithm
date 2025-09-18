import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    int idx = 1;
    
    public int solution(String word) {
        dfs(new char[]{'A', 'E', 'I', 'O', 'U'}, "");
        return map.get(word);
    }
    
    public void dfs(char[] arr, String s){
        if(!s.equals(""))   
            map.put(s, idx++);
        
        if(s.length() == 5){
            return;
        }
        
        for(int i=0; i<5; i++){
            dfs(arr, s + arr[i]);
        }
    }
}