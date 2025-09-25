import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        bfs(numbers, target);
        return answer;
    }
    
    public void bfs(int[] numbers, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int height = cur[0];
            int value = cur[1];
            
            if(value == target && height == numbers.length){
                answer++;
            }
            
            if(height >= numbers.length)
                continue;
            
            queue.add(new int[]{height + 1, value + numbers[height]});
            queue.add(new int[]{height + 1, value - numbers[height]});
            height++;
        }
    }
}