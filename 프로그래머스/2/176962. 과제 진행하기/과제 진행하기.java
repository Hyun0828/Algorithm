import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int idx = 0;
        
        PriorityQueue<Plan> pq = new PriorityQueue<>((a,b) -> a.start - b.start);
        Stack<Plan> stack = new Stack<>();
        
        for(int i=0; i<plans.length; i++){
            pq.add(new Plan(plans[i][0], convertToInt(plans[i][1]), Integer.parseInt(plans[i][2])));
        }
        
        Plan currentPlan = pq.poll();
        int currentTime = currentPlan.start;
        while(idx < answer.length){
            if(!pq.isEmpty()){
                Plan nextPlan = pq.peek();
                // 현재 과제를 못 끝냈는데 다음 과제를 시작해야 하면
                if(currentPlan.start + currentPlan.time > nextPlan.start){
                    currentPlan.time -= (nextPlan.start - currentPlan.start);
                    currentPlan.start = nextPlan.start; 
                    stack.push(new Plan(currentPlan.name, currentPlan.start, currentPlan.time));
    
                    currentTime = nextPlan.start;   
                    currentPlan = pq.poll();
                } 
                // 현재 과제를 다음 과제 시작 전에 끝낼 수 있으면 + 대기 과제를 먼저 실행하는 경우
                else if(currentPlan.start + currentPlan.time < nextPlan.start){
                    answer[idx++] = currentPlan.name;
                    currentTime = currentPlan.start + currentPlan.time;
                    if(!stack.isEmpty()) {
                        currentPlan = stack.pop();
                        currentPlan.start = currentTime;
                    } else
                        currentPlan = pq.poll();
                } else {
                    answer[idx++] = currentPlan.name;
                    currentTime = currentPlan.start + currentPlan.time;
                    currentPlan = pq.poll();
                }
            } else {
                answer[idx++] = currentPlan.name; // 과제가 대기 큐에만 있으면 지금 하던걸 끝낸다.
                if(stack.isEmpty())
                    break;
                currentPlan = stack.pop();
            }
        }
        
        return answer;
    }
    
    public int convertToInt(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    public static class Plan {
        String name;
        int start;
        int time;
        
        public Plan(String name, int start, int time){
            this.name = name;
            this.start = start;
            this.time = time;
        }
    }
    
    
}