import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    public int bfs(int x, int y, int n){
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(new int[]{x, 0});
        visited.add(x);
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int num = cur[0];
            int height = cur[1];
            
            // 10
            // 15 20 30
            // x x x 25 40 60
            // System.out.println(num);
            
            if(num > y){
                continue;
            }
            
            if(num == y){
                return height;
            }
            
            if(!visited.contains(num+n) && num + n <= y) {
                visited.add(num+n);
                queue.add(new int[]{num+n,height+1}); 
            }
            
            if(!visited.contains(num*2) || num * 2 <= y){
                visited.add(num*2);
                queue.add(new int[]{num*2,height+1});
            }
            
            if(!visited.contains(num*3) || num * 3 <= y){
                visited.add(num*3);
                queue.add(new int[]{num*3,height+1});
            }
            
            
        }
        
        return -1;
    }

}