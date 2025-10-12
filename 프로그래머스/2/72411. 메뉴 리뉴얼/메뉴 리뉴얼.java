import java.util.*;

class Solution {
    
    Map<Integer, Map<String, Integer>> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for(String order : orders){
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            for(int i=0; i<course.length; i++){
                combination(arr, "", course[i], 0);
            }
        }
        
        Set<String> set = new TreeSet<>();
        for(int i=0; i<course.length; i++){
            if(!map.containsKey(course[i]))
                continue;
            Map<String, Integer> m = map.get(course[i]);
            int max = 0;
            for(String s : m.keySet()){
                max = Math.max(max, m.get(s));
            }
            for(String s : m.keySet()){
                if(m.get(s) == max && max > 1){
                    set.add(s);
                }
            }
        }
        
        String[] answer = new String[set.size()];
        int idx = 0;
        for(String s : set){
            answer[idx++] = s;
        }
        
        return answer;
    }
    
    public void combination(char[] arr, String s, int count, int start){
        if(s.length() == count){
            map.putIfAbsent(s.length(), new HashMap<>());
            Map<String, Integer> m = map.get(s.length());
            m.put(s, m.getOrDefault(s, 0) + 1);
            return;
        }
        
        for(int i=start; i<arr.length; i++){
            combination(arr, s+arr[i], count, i+1);
        }
    }
}