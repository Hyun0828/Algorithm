import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르별 재생횟수
        Map<String, Integer> gMap = new HashMap<>();
        // 장르 내에서 노래별 재생 횟수
        Map<String, PriorityQueue<Song>> sMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            gMap.put(genre, gMap.getOrDefault(genre, 0) + play);
            sMap.putIfAbsent(genre, new PriorityQueue<Song>());
            PriorityQueue<Song> pq = sMap.get(genre);
            pq.add(new Song(play, i));
        }
        
        PriorityQueue<Genre> gpq = new PriorityQueue<>();
        for(String s : gMap.keySet()){
            gpq.add(new Genre(s, gMap.get(s)));
        }
        
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        while(!gpq.isEmpty()){
            String genre = gpq.poll().genre;
            PriorityQueue<Song> spq = sMap.get(genre);
            int count = 0;
            while(count < 2 && !spq.isEmpty()){
                result.add(spq.poll().idx);
                count++;
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++)
            answer[i] = result.get(i);
        return answer;
    }
    
    public static class Genre implements Comparable<Genre> {
        String genre;
        int play;
        
        public Genre(String genre, int play){
            this.genre = genre;
            this.play = play;
        }
        
        @Override
        public int compareTo(Genre g){
            return g.play - this.play;
        }
    }
    
    public static class Song implements Comparable<Song> {
        int play;
        int idx;
        
        public Song(int play, int idx){
            this.play = play;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Song s){
            return s.play - this.play;
        }
    }
}