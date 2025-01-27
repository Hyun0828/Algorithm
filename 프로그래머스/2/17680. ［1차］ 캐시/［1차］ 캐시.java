import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        for(int i=0; i<cities.length; i++){
            cities[i] = cities[i].toUpperCase();
        }
        
        if(cacheSize > 0){
            
            Queue<String> queue = new LinkedList<>();
            for(int i=0; i<cities.length; i++){
                String city = cities[i];
                if(!queue.isEmpty()){
                    // 캐싱
                    if(queue.contains(city)){
                        queue.remove(city);
                        queue.add(city);
                        answer++;
                    } else {
                        // 캐시가 꽉차면 교체한다.
                        if(queue.size() == cacheSize){
                            queue.poll();
                            queue.add(city);
                            answer += 5;
                        } else if(queue.size() < cacheSize){
                            queue.add(city);
                            answer += 5;
                        }
                    }
                } else {
                    queue.add(city);
                    answer += 5;
                }
            }
        } else {
            answer += cities.length * 5;
        }
        
        return answer;
    }
}