import java.util.*;

class Solution {
    
    Map<String, PriorityQueue<String>> tmp = new HashMap<>();
    Map<String, List<String>> map = new HashMap<>();
    Map<String, boolean[]> visited = new HashMap<>();
    List<String> answer = new ArrayList<>();
        
    public String[] solution(String[][] tickets) {    
        init(tickets);
        dfs("ICN", new Stack<>(), 0, tickets.length);
        return answer.toArray(new String[0]);
    }
    
    public void init(String[][] tickets){
        for(int i=0; i<tickets.length; i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            tmp.putIfAbsent(from, new PriorityQueue<>());
            PriorityQueue<String> pq = tmp.get(from);
            pq.add(to);
        }
        
        for(String s : tmp.keySet()){
            PriorityQueue<String> pq = tmp.get(s);
            map.putIfAbsent(s, new ArrayList<>());
            visited.putIfAbsent(s, new boolean[pq.size()]);
            
            List<String> list = map.get(s);
            while(!pq.isEmpty()){
                list.add(pq.poll());
            }
        }
    }
    
    public boolean dfs(String start, Stack<String> stack, int count, int len) {
        if(count == len){
            answer.add("ICN");
            answer.addAll(stack);
            return true;
        }
        
        if(!map.containsKey(start)){
            return false;
        }
        
        List<String> list = map.get(start);
        boolean[] vis = visited.get(start);
        
        for(int i=0; i<list.size(); i++){
            if(vis[i])
                continue;
            
            vis[i] = true;
            stack.push(list.get(i));
            if(dfs(list.get(i), stack, count + 1, len)){
                return true;
            }
            stack.pop();
            vis[i] = false;
        }
        
        return false;
    }
}