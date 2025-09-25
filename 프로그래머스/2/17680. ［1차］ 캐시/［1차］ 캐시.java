import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // 캐시 자료구조 : Map<String, Integer>, cache miss일 때는 Integer 값이 가장 작은 key를 제거한다.
        // cache hit면 Integer 값을 업데이트 하는데, 도시의 index로
        for(int i=0; i<cities.length; i++){
            cities[i] = cities[i].toUpperCase();
        }
    
        Map<String, Integer> cache = new HashMap<>();
        
        if(cacheSize == 0) {
            return cities.length * 5;  // 전부 cache miss
        }
        
        for(int i=0; i<cities.length; i++){
            // cache hit
            if(cache.containsKey(cities[i])){
                cache.put(cities[i], i);
                answer++;
            }
            // cache miss
            else {
                if(cache.size() < cacheSize){
                    cache.put(cities[i], i);
                    answer += 5;    
                } else {
                    cacheMiss(cache, cities[i], i);
                    answer += 5;
                }
            }
        }
        
        return answer;
    }
    
    public void cacheMiss(Map<String, Integer> cache, String city, int idx){
        String target = "";
        int min = 1000000;
        for(String s : cache.keySet()){
            if(min > cache.get(s)){
                target = s;
                min = cache.get(s);
            }
        }
        
        cache.remove(target);
        cache.put(city, idx);
    }
}