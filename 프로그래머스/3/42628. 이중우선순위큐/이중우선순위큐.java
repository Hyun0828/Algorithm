import java.util.*; 

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<operations.length; i++){
            char op = operations[i].charAt(0);
            String s = operations[i].substring(2);
            int num = Integer.parseInt(s);
            if(op == 'I'){
                maxHeap.add(num);
                minHeap.add(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if(op == 'D'){
                if(num == -1){
                    if(minHeap.isEmpty())
                        continue;
                    while(!minHeap.isEmpty()){
                        int n = minHeap.peek();
                        if(map.get(n) == 0)
                            minHeap.poll();
                        else {
                            minHeap.poll();
                            map.put(n, map.get(n) - 1);
                            break;
                        }
                    }
                } else if (num == 1){
                    if(maxHeap.isEmpty())
                        continue;
                    while(!maxHeap.isEmpty()){
                        int n = maxHeap.peek();
                        if(map.get(n) == 0)
                            maxHeap.poll();
                        else {
                            maxHeap.poll();
                            map.put(n, map.get(n) - 1);
                            break;
                        }
                    }
                }
            }
        }
        
        // 
        // 123
        
        while(!maxHeap.isEmpty()){
            int n = maxHeap.peek();
            if(map.get(n) == 0)
                maxHeap.poll();
            else
                break;
        }
        
        while(!minHeap.isEmpty()){
            int n = minHeap.peek();
            if(map.get(n) == 0)
                minHeap.poll();
            else
                break;
        }
        
        if(maxHeap.isEmpty() && minHeap.isEmpty())
            return new int[]{0, 0};        
        return new int[]{maxHeap.poll(), minHeap.poll()};
    }
}