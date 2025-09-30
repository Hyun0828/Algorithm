import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Set<String> dict = new HashSet<>();
        for(int i=0; i<words.length; i++)
            dict.add(words[i]);
        
        // BFS에서 높이
        if(!dict.contains(target))
            return 0;
        return bfs(begin, target, dict);
    }
    
    
    public int bfs(String begin, String target, Set<String> dict){
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Node(begin, 0));
        visited.add(begin);
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            String s = cur.word;
            int height = cur.height;
            
            if(s.equals(target)){
                return height;
            }
            
            for(String d : dict){
                if(d.length() != s.length())
                    continue;
                
                int count = 0;
                for(int i=0; i<s.length(); i++){
                    char sc = s.charAt(i);
                    char dc = d.charAt(i);
                    if(sc != dc){
                        count++;
                    }
                }
                
                if(count == 1){
                    visited.add(d);
                    queue.add(new Node(d, height+1));
                }
            }
        }
        return 0;
    }
    
    public static class Node {
        String word;
        int height;
        
        public Node(String word, int height){
            this.word = word;
            this.height= height;
        }
    }
}