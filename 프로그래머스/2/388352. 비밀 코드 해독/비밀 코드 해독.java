import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        combination(q, ans, n, 1, new HashSet<>());
        return answer;
    }
    
    public static void combination(int[][] q, int[] ans, int n, int start, Set<Integer> set){
        if(set.size() == 5){
            boolean isOk = true;
            for(int i=0; i<q.length; i++){
                int[] num = q[i];
                int cnt = 0;
                for(int j=0; j<num.length; j++){
                    if(set.contains(num[j]))
                        cnt++;
                }
                if(cnt != ans[i]){
                    isOk = false;
                    break;
                }
            }
            if(isOk)
                answer++;
            return;
        }
        
        for(int i=start; i<=n; i++){
            set.add(i);
            combination(q, ans, n, i+1, set);
            set.remove(i);
        }
    }
}