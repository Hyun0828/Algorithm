import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int playIdx = 1;
        
        int[] arr = new int[10];
        Queue<Process> queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            arr[priorities[i]]++;
            queue.add(new Process(priorities[i], i));
        }
        
        while(!queue.isEmpty()){
            Process process = queue.poll();
            int priority = process.priority;
            
            // 우선순위가 큰 프로세스가 있다면
            if(check(arr, priority)){
                queue.add(process);
            } else {
                if(process.idx == location){
                    answer = playIdx++;
                    arr[priority]--;
                    break;
                } else {
                    playIdx++;
                    arr[priority]--;
                }
            }
        }
        
        return answer;
    }
    
    public boolean check(int[] arr, int priority){
        for(int i=priority + 1; i<10; i++){
            if(arr[i] > 0)
                return true;
        }
        return false;
    }
    
    public static class Process {
        int priority;
        int idx;
        
        public Process(int priority, int idx){
            this.priority = priority;
            this.idx = idx;
        }
    }
}