import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        str1 = this.toLowerCase(str1);
        str2 = this.toLowerCase(str2);
        
        Map<String, Integer> map1 = this.splitString(str1);
        Map<String, Integer> map2 = this.splitString(str2);    
        
        return this.getSimilarity(map1, map2);
    }
    
    public String toLowerCase(String str){
        return str.toLowerCase();
    }
    
    public Map<String, Integer> splitString(String str){
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<str.length() - 1; i++){
            char a = str.charAt(i);
            char b = str.charAt(i+1);
            
            if(Character.isLetter(a) && Character.isLetter(b)){
                StringBuilder sb = new StringBuilder();
                sb.append(a);
                sb.append(b);
                String s = sb.toString();
                
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        
        return map;
    }
    
    // 합집합과 교집합을 구한다.
    public int getSimilarity(Map<String, Integer> map1, Map<String, Integer> map2){
        
        if(map1.isEmpty() && map2.isEmpty())
            return 65536;
        
        Map<String, Integer> intersect = new HashMap<>();
        Map<String, Integer> union = new HashMap<>();
        Set<String> both = new HashSet<>();
        
        int num_intersect = 0;
        int num_union = 0;
        
        // 중복 문자열을 먼저 찾는다.
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                int min = Math.min(map1.get(key), map2.get(key));
                int max = Math.max(map1.get(key), map2.get(key));
                
                intersect.put(key, min);
                union.put(key, max);
                both.add(key);
            }
        }
        
        for(String key : map1.keySet()){
            if(!both.contains(key)){
                union.put(key, map1.get(key));
            }
        }
        
        for(String key : map2.keySet()){
            if(!both.contains(key)){
                union.put(key, map2.get(key));
            }
        }
        
        // 유사도를 계산한다.
        for(String key : intersect.keySet()){
            num_intersect += intersect.get(key);
        }
        
        for(String key : union.keySet()){
            num_union += union.get(key);
        }
        
        return (int)65536 * num_intersect / num_union;
    }
}