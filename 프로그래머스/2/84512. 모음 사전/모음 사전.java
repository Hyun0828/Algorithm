import java.util.*;

class Solution {
    
    List<String> arr = new ArrayList<>();
    char[] carr = new char[]{'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        dfs("", 0);
        return arr.indexOf(word);
    }
    
    public void dfs(String word, int depth){
        if(depth > 5) return;
        arr.add(word);
        
        for(int i=0; i<5; i++){
            dfs(word+carr[i], depth+1);
        }
    }
}