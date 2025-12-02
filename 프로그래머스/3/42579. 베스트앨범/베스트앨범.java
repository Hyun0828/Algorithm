import java.util.*;

class Solution {
    
    Map<String, Integer> genreMap = new HashMap<>();
    Map<String, PriorityQueue<Song>> songMap = new HashMap<>(); 
    
    public int[] solution(String[] genres, int[] plays) {  
        for(int i=0; i<genres.length; i++){
            int songNum = i;
            String genre = genres[i];
            int play = plays[i];
            
            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + play);
            songMap.putIfAbsent(genre, new PriorityQueue<>());
            PriorityQueue<Song> pq = songMap.get(genre);
            pq.add(new Song(songNum, play));
        }
        
        List<Integer> result = new ArrayList<>();
        
        PriorityQueue<Genre> genreHeap = new PriorityQueue<>();
        for(String s : genreMap.keySet()){
            genreHeap.add(new Genre(s, genreMap.get(s)));
        }
        
        while(!genreHeap.isEmpty()){
            int num = 0;
            Genre genre = genreHeap.poll();
            PriorityQueue<Song> pq = songMap.get(genre.genre);
            while(!pq.isEmpty()){
                if(num == 2){
                    break;
                }
                Song song = pq.poll();
                result.add(song.songNum);
                num++;
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public static class Genre implements Comparable<Genre>{
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
    
    public static class Song implements Comparable<Song>{
        int songNum;
        int play;
        
        public Song(int songNum, int play){
            this.songNum = songNum;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song s){
            if(this.play == s.play){
                return this.songNum - s.songNum;
            } else {
                return s.play - this.play;
            }
        }
    }
}