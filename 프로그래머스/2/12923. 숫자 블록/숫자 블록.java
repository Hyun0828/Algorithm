import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        List<Integer> answer = new LinkedList<>();
        
        for(int i=(int)begin; i<=(int)end; i++){
            if(solve(i) != i)
                answer.add(solve(i));
            else
                answer.add(1);
        }
        
        int[] ans = new int[answer.size()];
        for(int i=0; i<ans.length; i++)
            ans[i] = answer.get(i);
        
        return ans;
    }
    
    private int solve(int n){
        if(n==1)
            return 0;
        
        List<Integer> l = new LinkedList<>();
        
        int root = (int)Math.sqrt(n);
        for(int i=2; i<=root; i++){
            if(n%i==0){
                l.add(i);
                if(n/i<=10000000)
                    return n/i;
            }   
        }
        
        if(!l.isEmpty())
            return l.get(l.size()-1);
        
        return 1;
    }
}