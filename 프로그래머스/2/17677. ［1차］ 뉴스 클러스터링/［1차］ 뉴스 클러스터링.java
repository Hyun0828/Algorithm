import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        Map<String, Integer> map1 = convert(str1);
        Map<String, Integer> map2 = convert(str2);
        
        // 교집합 & 합집합 구하기
        int guo = guo(map1, map2);
        int hap = hap(map1, map2);
        
        if(guo == 0 && hap == 0)
            return 65536;
        return (int)Math.floor((double)guo / hap * 65536);
    }
    
    public int guo(Map<String, Integer> map1, Map<String, Integer> map2){
        Map<String, Integer> map = new HashMap<>();
        for(String s : map1.keySet()){
            if(map2.containsKey(s)){
                map.put(s, Math.min(map1.get(s), map2.get(s)));
            }
        }
        
        for(String s : map2.keySet()){
            if(map1.containsKey(s)){
                map.put(s, Math.min(map1.get(s), map2.get(s)));
            }
        }
        
        int answer = 0;
        for(String s : map.keySet()){
            answer += map.get(s);
        }
        
        return answer;
    }
    
    public int hap(Map<String, Integer> map1, Map<String, Integer> map2){
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : map1.keySet()){
            if(map2.containsKey(s)){
                map.put(s, Math.max(map1.get(s), map2.get(s)));
            } else {
                map.put(s, map1.get(s));
            }
        }
                        
        for(String s : map2.keySet()){
            if(map1.containsKey(s)){
                map.put(s, Math.max(map1.get(s), map2.get(s)));
            } else {
                map.put(s, map2.get(s));
            }
        }
        
        int answer = 0;
        for(String s : map.keySet()){
            answer += map.get(s);
        }
        
        return answer;
    }
    
    public Map<String, Integer> convert(String s){
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length() - 1; i++){
            String sub = s.substring(i, i+2);
            boolean isLetter = true;
            for(int j=0; j<2; j++){
                if(!Character.isLetter(sub.charAt(j))){
                    isLetter = false;
                    break;
                }
            }
            if(!isLetter)
                continue;
            sub = sub.toUpperCase();
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        
        return map;
    }
}