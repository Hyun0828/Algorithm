import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    
    public List<String> convert(String begin, String[] words){
        List<String> list = new ArrayList<>();
        for(int i=0; i<begin.length(); i++){
            for(String word : words){
                boolean isSame = true;
                for(int j=0; j<begin.length(); j++){
                    if(i==j)
                        continue;
                    if(begin.charAt(j) != word.charAt(j))
                        isSame = false;
                }
                if(isSame)
                    list.add(word);
            }
        }
        return list;
    }
    
    public int bfs(String begin, String target, String[] words){
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(new Node(begin, 0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            if(node.s.equals(target))
                return node.height;
            
            if(visited.contains(node.s))
                continue;
            visited.add(node.s);
            
            // convert로 변경 가능 단어들을 받아와서 queue에 넣기
            List<String> list = convert(node.s, words);
            for(String s : list){
                if(visited.contains(s))
                    continue;
                queue.add(new Node(s, node.height+1));
            }
        }
        
        return 0;
    }
    
    public static class Node {
        String s;
        int height;
        
        public Node(String s, int height){
            this.s=s;
            this.height=height;
        }
    }
}