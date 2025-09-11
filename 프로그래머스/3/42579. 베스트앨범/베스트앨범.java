import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르별 재생 횟수
        Map<String, Integer> genreCountMap = new HashMap<>();
        
        // 해당 장르에서 재생 횟수
        Map<String, Map<Integer, Integer>> playCountMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            genreCountMap.put(genre, genreCountMap.getOrDefault(genre, 0) + play);
            playCountMap.putIfAbsent(genre, new HashMap<>());
            Map<Integer, Integer> map = playCountMap.get(genre);
            map.put(i, map.getOrDefault(i, 0) + play);
        }
        
        // 장르별 재생 순서 
        PriorityQueue<A> pq = new PriorityQueue<>();
        for(String key : genreCountMap.keySet()){
            pq.add(new A(key, genreCountMap.get(key)));
        }
        
        List<Integer> answer = new ArrayList<>();
        int index = 0;
        
        while(!pq.isEmpty()){
            PriorityQueue<B> q = new PriorityQueue<>();
            A a = pq.poll();
            Map<Integer, Integer> map = playCountMap.get(a.genre);
            
            for(Integer i : map.keySet()){
                q.add(new B(i, map.get(i)));
            }
            
            answer.add(q.poll().num);
            if(!q.isEmpty())
                answer.add(q.poll().num);
        }
        
        int[] result = new int[answer.size()];
        for(int i=0; i<result.length; i++){
            result[i] = answer.get(i);
        }
        
        return result;
        
    }
    
    public static class A implements Comparable<A> {
        String genre;
        int play;
        
        public A(String genre, int play){
            this.genre = genre;
            this.play = play;
        }
        
        @Override
        public int compareTo(A a){
            return a.play - this.play;
        }
    }
    
    public static class B implements Comparable<B>{
        int num;
        int play;
        
        public B(int num, int play){
            this.num = num;
            this.play = play;
        }
        
        @Override
        public int compareTo(B b){
            return b.play - this.play;
        }
    }
}