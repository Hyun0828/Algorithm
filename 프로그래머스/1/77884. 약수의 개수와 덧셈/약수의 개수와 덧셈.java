import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++){
            if(isRoot(i))
                answer -= i;
            else
                answer += i;
        }
        
        return answer;
    }
    
    private boolean isRoot(Integer x){
        
        Double root = Math.sqrt(x);
        if(root.intValue() == root)
            return true;
        else
            return false;
    }
}