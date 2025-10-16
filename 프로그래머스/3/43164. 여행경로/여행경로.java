import java.util.*;

class Solution {
    
    Map<String, List<String>> airLine = new HashMap<>();
    Map<String, boolean[]> visited = new HashMap<>();
    
    List<String> result = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        for(int i=0; i<tickets.length; i++){
            String a = tickets[i][0];
            String b = tickets[i][1];
            
            airLine.putIfAbsent(a, new ArrayList<>());
            List<String> list = airLine.get(a);
            list.add(b);
        }
        
        for(String key : airLine.keySet()){
            Collections.sort(airLine.get(key));
            int len = airLine.get(key).size();
            visited.putIfAbsent(key, new boolean[len]);
        }
        
        List<String> t = new ArrayList<>();
        t.add("ICN");
        
        dfs("ICN", t, 0, tickets.length);
        
        return result.toArray(new String[0]);
    }
    
    public String convert(List<String> route){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<route.size(); i++)
            sb.append(route.get(i));
        return sb.toString();
    }
    
    public void dfs(String start, List<String> route, int count, int len){
        if (count == len) {
            if (result.isEmpty() || convert(route).compareTo(convert(result)) < 0) {
                result = new ArrayList<>(route);
            }
            return;
        }
        
        List<String> list = airLine.get(start);
        boolean[] visit = visited.get(start);
        if (list == null) return;
        
        for(int i=0; i<list.size(); i++){
            if(visit[i])
                continue;
            visit[i] = true;
            List<String> nroute = new ArrayList<>(route);
            nroute.add(list.get(i));
            dfs(list.get(i), nroute, count + 1, len);
            visit[i] = false;
        }
    }
}