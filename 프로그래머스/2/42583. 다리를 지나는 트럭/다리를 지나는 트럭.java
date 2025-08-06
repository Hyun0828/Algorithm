import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리 위에 올라간 트럭들의 무게 합 : int sumWeightOnBridge
        // 다리 위에 올라간 트럭 개수 : int countTruckOnBridge
        // 다리 위에서 트럭이 어디에 있느냐,, 맨 앞에 있으면 트럭이 새로 못 올라가니까,, "다리 위의 트럭 위치를 어떻게 표현할까"
        // 모든 트럭의 위치를 표현 X -> 맨 앞에 있냐 없냐만 변수로 두는거지, boolean isFront;
        // 트럭들은 다리에 들어간 시각을 같이 class로 넣고, queue.peek().time이 현재시각에서 뺀 값이 bridge_length일 때 빠져나옴
        
        int truckIndex = 0;
        int sumWeightOnBridge = 0;
        int countTruckOnBridge = 0;
        boolean isFront = false;
        int currentTime = 1;
        Queue<Truck> queue = new LinkedList<>();
        
        while(true){
            // 마지막 트럭이 터널에서 탈출 먼저 하고
            if(!queue.isEmpty()) {
                Truck lastTruck = queue.peek();
                // 터널에서 빠져나옴
                if(currentTime - lastTruck.enterTime == bridge_length){
                    queue.poll();
                    sumWeightOnBridge -= truck_weights[lastTruck.idx];
                    countTruckOnBridge -= 1;
                }
            }
            
            if(truckIndex == truck_weights.length && queue.isEmpty())
                break;
            
            
            // 트럭이 남아있다면
            if(truckIndex < truck_weights.length){
                // 무게가 넘치면 X
                if(sumWeightOnBridge + truck_weights[truckIndex] > weight){
                    currentTime++;
                    continue;
                } 

                // 다리에 올라갈 수 있는 트럭 수를 초과하면 X
                if(countTruckOnBridge + 1 > bridge_length){
                    currentTime++;
                    continue;
                }
                
                queue.add(new Truck(truckIndex, currentTime));
                sumWeightOnBridge += truck_weights[truckIndex++];
                countTruckOnBridge += 1;
            }
            
            currentTime++;
        }
        
        return currentTime;
    }
    
    static class Truck {
        int idx;
        int enterTime;
        
        public Truck(int idx, int enterTime){
            this.idx = idx;
            this.enterTime = enterTime;
        }
    }
}