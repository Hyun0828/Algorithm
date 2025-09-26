import java.util.*;

class Solution {
    int answer = 0;
    int index = 0;
    
    public int solution(String word) {        
        char[] arr = new char[]{'A', 'E', 'I', 'O', 'U'};
        dfs(arr, "", word);
        return answer;
    }
    
    public void dfs(char[] arr, String s, String target) {    
        index++;
        
        if(s.equals(target)){
            answer = index - 1;
            return;
        }
        
        if(s.length() == 5) {
            return;
        }
        

        for(int i=0; i<5; i++){
            dfs(arr, s+arr[i], target);
        }
    }
}