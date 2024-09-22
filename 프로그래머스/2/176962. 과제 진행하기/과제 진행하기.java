import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int idx = 0;
        
        PriorityQueue<Homework> queue = new PriorityQueue<>();
        Stack<Homework> stack = new Stack<>();
        int total_playtime = 0;
        int total_starttime = 0;
        
        for(int i=0; i<plans.length; i++){
            String[] plan = plans[i];
            total_playtime += Integer.parseInt(plan[2]);
            queue.add(new Homework(plan[0], timeToint(plan[1]), Integer.parseInt(plan[2])));
        }
        total_starttime = queue.peek().start;
        
        // Q. 과제를 하지 않는 시간이 있을 수도 있다.
        
        // 전체 과제 진행 시간 동안
        Homework hw = queue.poll();
        int time = total_starttime;
        while(hw.playtime!=0 || !queue.isEmpty() || !stack.isEmpty()){
            time++;
            hw.playtime--;
            
            // 하고 있는 과제를 다했는데
            if(hw.playtime == 0){
                answer[idx++] = hw.subject;
                
                if(!queue.isEmpty()){
                    Homework newHw = queue.peek();
                    // 새로운 과제 시작 시간이면 새로운 과제를 시작한다.
                    if(newHw.start == time){
                        // 하고 있는 과제가 아직 남았다면 과제 중단
                        if(hw.playtime > 0)
                            stack.push(hw);
                        hw = queue.poll();
                    }
                    // 아니면 멈췄던 과제를 시작한다.
                    else {
                        if(!stack.isEmpty())
                            hw = stack.pop();   
                    }
                }
                // 남은 새로운 과제가 없으면 멈췄던 과제를 시작한다.
                else {
                    if(!stack.isEmpty())
                        hw = stack.pop();   
                }
            }
            // 과제를 다 못했는데
            else {
               if(!queue.isEmpty()){
                    Homework newHw = queue.peek();
                    // 새로운 과제 시작 시간이면 새로운 과제를 시작한다.
                    if(newHw.start == time){
                        // 하고 있는 과제가 아직 남았다면 과제 중단
                        if(hw.playtime > 0)
                            stack.push(hw);
                        hw = queue.poll();
                    }    
                } 
            }   
        }
        
//         for(int i=total_starttime+1; i<=total_starttime+total_playtime; i++){
            
//             hw.playtime--;
            
//             // 하고 있는 과제를 다했는데
//             if(hw.playtime == 0){
//                 answer[idx++] = hw.subject;
                
//                 if(!queue.isEmpty()){
//                     Homework newHw = queue.peek();
//                     // 새로운 과제 시작 시간이면 새로운 과제를 시작한다.
//                     if(newHw.start == i){
//                         // 하고 있는 과제가 아직 남았다면 과제 중단
//                         if(hw.playtime > 0)
//                             stack.push(hw);
//                         hw = queue.poll();
//                     }
//                     // 아니면 멈췄던 과제를 시작한다.
//                     else {
//                         if(!stack.isEmpty())
//                             hw = stack.pop();   
//                     }
//                 }
//                 // 남은 새로운 과제가 없으면 멈췄던 과제를 시작한다.
//                 else {
//                     if(!stack.isEmpty())
//                         hw = stack.pop();   
//                 }
//             }
//             // 과제를 다 못했는데
//             else {
//                if(!queue.isEmpty()){
//                     Homework newHw = queue.peek();
//                     // 새로운 과제 시작 시간이면 새로운 과제를 시작한다.
//                     if(newHw.start == i){
//                         // 하고 있는 과제가 아직 남았다면 과제 중단
//                         if(hw.playtime > 0)
//                             stack.push(hw);
//                         hw = queue.poll();
//                     }    
//                 } 
//             }   
//         }
        
        return answer;
    }
    
    private int timeToint(String time){
        String[] temp = time.split(":");
        int sum = 0;
        
        sum += Integer.parseInt(temp[0]) * 60;
        sum += Integer.parseInt(temp[1]);
        
        return sum;
    }
}

class Homework implements Comparable<Homework>{
    
    String subject;
    int start;
    int playtime;
    
    public Homework(String subject, int start, int playtime){
        this.subject = subject;
        this.start = start;
        this.playtime = playtime;
    }
    
    @Override
    public int compareTo(Homework h){
        return this.start - h.start;
    }
}