import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx = 0;
        int current_weight = 0;
        int current_time = 1;
        Queue<Truck> bridge = new LinkedList<>();
        
        while(true){            
            // 다리에서 맨 앞에 있는 트럭이 다리에서 나올 수 있으면
            if(!bridge.isEmpty()){
                Truck firstTruck = bridge.peek();
                if(current_time - firstTruck.enterTime >= bridge_length){
                    bridge.poll();
                    current_weight -= firstTruck.weight;
                }
            }
            
            if(idx == truck_weights.length && bridge.isEmpty()){
                break;
            }
            
            // 트럭이 다리 위로 올라갈 수 있으면
            if(idx < truck_weights.length){
               if(bridge.size() + 1 <= bridge_length && current_weight + truck_weights[idx] <= weight){
                    bridge.add(new Truck(truck_weights[idx], current_time));
                    current_weight += truck_weights[idx];
                    idx++;
                } 
            }
            
            current_time++;
        }
        // 1 3 4 6 
        
        
        return current_time;
    }
    
    public static class Truck {
        int weight;
        int enterTime;
        
        public Truck(int weight, int enterTime){
            this.weight = weight;
            this.enterTime = enterTime;
        }
    }
}