import java.util.*;

class Solution {
    Queue<Process> queue = new LinkedList<>();
    PriorityManager pm = new PriorityManager();
    
    public int solution(int[] priorities, int location) {
        init(priorities); // 실행 대기 큐 초기화
        return run(location); // 프로세스 실행
    }
    
    public void init(int[] priorities){
        for(int i=0; i<priorities.length; i++){
            Process process = new Process(i, priorities[i]);
            queue.add(process);
            pm.add(priorities[i]);
        }
    }
    
    public int run(int location){
        int count = 0;
        while(!queue.isEmpty()){
            Process process = queue.poll();
            
            // 우선순위가 더 높은 프로세스가 있다면 다시 큐에 넣는다.
            if(process.getPriority() < pm.getMaxPriority()){
                queue.add(process);    
            } 
            // 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행한다.
            else {
                count++;
                // max_priority 조정 로직
                pm.decrease();
                // 순서를 알고 싶은 프로세스라면
                if(process.getNumber() == location){
                    break;
                }
            }
        }
        return count;
    }
}

class PriorityManager{
    private PriorityQueue<Integer> maxHeap;
    private Map<Integer, Integer> map;
    
    public PriorityManager(){
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        map = new HashMap<>();
    }
    
    public void add(int priority){
        map.put(priority, map.getOrDefault(priority,0)+1);
        if(map.get(priority) == 1)
            maxHeap.add(priority);
    }
    
    public void decrease(){
        if(maxHeap.isEmpty())
            return;
        
        int max_priority = maxHeap.peek();
        map.put(max_priority, map.get(max_priority)-1);
        
        if(map.get(max_priority) == 0){
            maxHeap.poll();
            map.remove(max_priority);
        }
    }
    
    public int getMaxPriority(){
        if(maxHeap.isEmpty())
            return -1;
        return maxHeap.peek();
    }
}

class Process{
    private int number;
    private int priority;
    
    public Process(int number, int priority){
        this.number = number;
        this.priority = priority;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public int getPriority(){
        return this.priority;
    }
}