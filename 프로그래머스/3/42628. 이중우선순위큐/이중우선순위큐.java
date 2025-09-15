import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        // 우선순위 큐 : 최대힙/최소힙
        // 큐가 1개면 최댓값 연산 or 최솟값 연산 둘 중 1개만 처리할 수 있다.
        // 그럼 큐를 2개 쓰면 처리할 수 있을까?
        // 최댓값 연산은 최대힙에서, 최솟값 연산은 최소힙에서 처리한다면,, 추가 연산은?
        // 일단 이건 안 되긴 함. 그냥 해보면 답이 이상함
        
        // 삽입하는 숫자들을 Map<Integer, Integer>로 관리하고
        // 각 힙에서 삭제할 때 map에서 개수를 줄인다.
        
        // -45, 653, 45, 97, 333
        // -45, 45, 333
        
        // -45 45 333  
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<operations.length; i++){
            String op = operations[i].split(" ")[0];
            int num = Integer.parseInt(operations[i].split(" ")[1]);
            
            if(op.equals("I")){
                maxHeap.add(num);
                minHeap.add(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if(op.equals("D")){
                if(num == 1){
                    while(!maxHeap.isEmpty()){
                        int n = maxHeap.poll();
                        if(map.get(n) > 0){
                            map.put(n, map.get(n) - 1);
                            break;
                        }
                    }
                } else {
                    while(!minHeap.isEmpty()){
                        int n = minHeap.poll();
                        if(map.get(n) > 0){
                            map.put(n, map.get(n) - 1);
                            break;
                        }
                    }
                }
            }
        }
        
        while(!maxHeap.isEmpty()){
            int n = maxHeap.poll();
            if(map.get(n) > 0){
                answer[0] = n;
                break;
            }
        }
        while(!minHeap.isEmpty()){
            int n = minHeap.poll();
            if(map.get(n) > 0){
                answer[1] = n;
                break;
            }
        }
        
        
        return answer;
    }
}