import java.util.*;

class Solution {
    
    char[] member;
    boolean[] visited;
    int answer;
    
    public int solution(int n, String[] data) {
        answer = 0;
        member = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visited = new boolean[8];
        
        permutation(0, new HashMap<>(), data);
        
        return answer;
    }
    
    public boolean check(Map<Character, Integer> map, String[] data){
        for(int i=0; i<data.length; i++){
            char s = data[i].charAt(0);
            char e = data[i].charAt(2);
            char op = data[i].charAt(3);
            int n = data[i].charAt(4) - '0';
            
            int sn = map.get(s);
            int en = map.get(e);
            
            int diff = Math.abs(sn-en) - 1;
            
            if(op == '='){
                if(diff != n)
                    return false;
            } else if (op == '>'){
                if(diff <= n){
                    return false;
                }
            } else if (op == '<'){
                if(diff >= n){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void permutation(int count, Map<Character, Integer> map, String[] data){
        if(count == 8){
            if(check(map, data)){
                answer++;
            }
            return;
        }
        
        for(int i=0; i<8; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            map.put(member[i], count);
            permutation(count+1, map, data);
            map.remove(member[i]);
            visited[i] = false;
        }
    }
}