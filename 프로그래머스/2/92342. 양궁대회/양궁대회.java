import java.util.*;

class Solution {
    
    static Set<List<Integer>> set;
    static int maxPoint = 0;
    
    public int[] solution(int n, int[] info) {
        set = new HashSet<>();
        backtracking(info, new int[info.length], n, 0);
        
        if(set.size() == 0){
            return new int[]{-1};
        }
        
        if(set.size() == 1){
            int[] arr = new int[11];
            for(List<Integer> t : set) {
                for(int i=0; i<11; i++) {
                    arr[i] = t.get(i);
                }
            }
            return arr;
        }
        
        // 우선순위
        int[][] tmp = new int[set.size()][11];
        int y = 0;
        for(List<Integer> t : set){
            for(int i=0; i<11; i++){
                tmp[y][i] = t.get(i);
            }
            y++;
        }
        
        int[] answer = tmp[0];
        for(int i=1; i<tmp.length; i++){
            int[] cur = tmp[i];
            for(int j=10; j>=0; j--){
                if(answer[j] < cur[j]){
                    answer = tmp[i];
                    break;
                } else if(answer[j] > cur[j])
                    break;
            }
        }
        
        return answer;
    }
    
    public static int calculate(int[] info, int[] lion){
        int papeach = 0;
        int plion = 0;
        
        for(int i=0; i<info.length; i++){
            if(info[i] > 0 && lion[i] == 0) {
                papeach += (10 - i);
            } else if (info[i] == 0 && lion[i] > 0){
                plion += (10 - i);
            } else if(info[i] > 0 && lion[i] > 0){
                if(info[i] >= lion[i])
                    papeach += (10 - i);
                else 
                    plion += (10 - i);
            }
        }
        return plion - papeach;
    }
    
    public static void backtracking(int[] info, int[] lion, int n, int idx){
        if(idx == 11) {
            if(n > 0)
                lion[10] += n;
            int diff = calculate(info, lion);
            // 라이언이 최종 승리하면
            if(diff > 0){
                if(diff > maxPoint){
                    maxPoint = diff;
                    set.clear();
                    List<Integer> temp = new ArrayList<>();
                    for(int i=0; i<11; i++)
                        temp.add(lion[i]);
                    set.add(temp);
                } else if(diff == maxPoint){
                    List<Integer> temp = new ArrayList<>();
                    for(int i=0; i<11; i++)
                        temp.add(lion[i]);
                    set.add(temp);
                }
            }
            if(n > 0)   
                lion[10] -= n;
            return;
        }
        
        // idx 라운드에서 라이언이 승리하면
        if(n >= info[idx] + 1){
            lion[idx] = info[idx] + 1;
            backtracking(info, lion, n - info[idx] - 1, idx + 1);
            lion[idx] = 0;
        }
        
        // 어피치가 승리하면
        backtracking(info, lion, n, idx + 1);
    }
}