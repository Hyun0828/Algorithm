import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>(); // 다리
        int currentWeight = 0; // 다리 위에 올라간 트럭 무게 합
        int currentTime = 1; // 현재 시각
        int i = 0;
        
        while(true){
            if(!bridge.isEmpty()){
                if(currentTime - bridge.peek().enterTime == bridge_length){
                    Truck t = bridge.poll();
                    currentWeight -= t.weight;
                }
            }
            
            if(bridge.isEmpty() && i == truck_weights.length) {
                break;
            }
            
            if(i < truck_weights.length && bridge.size() + 1 <= bridge_length && currentWeight + truck_weights[i] <= weight){
                bridge.add(new Truck(currentTime, truck_weights[i]));
                currentWeight += truck_weights[i];   
                i++;
            }
            
            currentTime++;
        }
        
        return currentTime;
    }
    
    public static class Truck {
        int enterTime;
        int weight;
        
        public Truck(int enterTime, int weight){
            this.enterTime = enterTime;
            this.weight = weight;
        }
    }
}