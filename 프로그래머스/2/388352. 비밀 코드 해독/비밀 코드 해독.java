import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {        
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0; i<q.length; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<q[i].length; j++){
                set.add(q[i][j]);
            }
            list.add(set);
        }
        
        combination(n, list, ans, 1, new HashSet<>());
        
        return answer;
    }
    
    public void combination(int n, List<Set<Integer>> list, int[] ans, int start, Set<Integer> set){
        if(set.size() == 5){
            // 검사
            boolean isCorrect = true;
            for(int i=0; i<list.size(); i++){
                Set<Integer> temp = new HashSet<>(set);
                temp.retainAll(list.get(i));
                if(temp.size() != ans[i]){
                    isCorrect = false;
                    break;
                }
            }
            if(isCorrect){
                answer++;
            }
            return;
        }
        
        for(int i=start; i<=n; i++){
            set.add(i);
            combination(n, list, ans, i + 1, set);
            set.remove(i);
        }
    }
}