import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words){
        Queue<Word> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(new Word(begin, 0));
        visited.add(begin);
        
        while(!queue.isEmpty()){
            Word cur = queue.poll();
            
            if(cur.word.equals(target)){
                return cur.height;
            }
            
            for(String word : words){
                if(!visited.contains(word) && isOk(cur.word, word)){
                    visited.add(word);
                    queue.add(new Word(word, cur.height + 1));
                }
            }
        }
        
        return 0;
    }
    
    public boolean isOk(String begin, String word){
        if(begin.length() != word.length())
            return false;
        
        int count = 0;
        for(int i=0; i<begin.length(); i++){
            if(begin.charAt(i) != word.charAt(i))
                count++;
            
            if(count > 1)
                return false;
        }
        
        return true;
    }
    
    public static class Word {
        String word;
        int height;
        
        public Word(String word, int height){
            this.word = word;
            this.height = height;
        }
    }
}