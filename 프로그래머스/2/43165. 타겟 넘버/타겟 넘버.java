import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        bfs(numbers, target);
        return answer;
    }
    
    public void bfs(int[] numbers, int target){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(-1, 0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int idx = node.height;
            int value = node.value;
            
            if(value == target && idx == numbers.length - 1){
                answer++;
            }
            
            if(idx + 1 < numbers.length){
                queue.add(new Node(idx+1, value+numbers[idx+1]));
                queue.add(new Node(idx+1, value-numbers[idx+1]));
            }

        }
    }
    
    public static class Node {
        int height;
        int value;
        
        public Node(int height, int value){
            this.height = height;
            this.value = value;
        }
    }
}