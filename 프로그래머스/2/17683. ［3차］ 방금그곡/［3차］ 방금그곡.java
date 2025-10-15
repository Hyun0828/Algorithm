import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {        
        // 음악들의 풀 악보에 m이 포함되어 있는 지를 확인하는 문제
        PriorityQueue<Music> pq = new PriorityQueue<>();
        for(int i=0; i<musicinfos.length; i++){
            String[] tmp = musicinfos[i].split(",");
            int start = convertTime(tmp[0]);
            int end = convertTime(tmp[1]);
            int time = end - start;
            String title = tmp[2];
            String music = tmp[3];
            
            List<String> wholeMusic = parseMusic(time, music);
            boolean isContain = false;
            int len = parseMusic(m).size();
            for(int j=0; j<=wholeMusic.size() - len; j++){
                StringBuilder sb = new StringBuilder();
                for(int k=0; k<len; k++){
                    sb.append(wholeMusic.get(j+k));
                }
                if(sb.toString().equals(m)){
                    isContain = true;
                    break;
                }
            }
            if(isContain)
                pq.add(new Music(time, start, title));
        }
        
        if(pq.isEmpty()){
            return "(None)";
        }
        
        return pq.poll().title;
    }
    
    public List<String> parseMusic(String music){
        List<String> list = new ArrayList<>();
        for(int i=0; i<music.length(); i++){
            if(i < music.length() - 1 && music.charAt(i+1) == '#'){
                list.add(music.substring(i, i+2));
                i++;
            } else {
                list.add(music.substring(i, i+1));
            }
        }
        return list;
    }
    
    public List<String> parseMusic(int time, String music){
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for(int i=0; i<music.length(); i++){
            if(i < music.length() - 1 && music.charAt(i+1) == '#'){
                list.add(music.substring(i, i+2));
                i++;
            } else {
                list.add(music.substring(i, i+1));
            }
        }
        
        if(list.size() >= time){
            for(int i=0; i<time; i++){
                result.add(list.get(i));
            }
        } else {
            int q = time / list.size();
            int r = time % list.size();
            for(int i=0; i<q; i++){
                for(int j=0; j<list.size(); j++){
                    result.add(list.get(j));
                }
            }
            for(int i=0; i<r; i++){
                result.add(list.get(i));
            }
        }
        return result;
    }
    
    public int convertTime(String time){
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
    
    public static class Music implements Comparable<Music>{
        int length;
        int start;
        String title;
        
        public Music(int length, int start, String title){
            this.length=length;
            this.start=start;
            this.title=title;
        }
        
        @Override
        public int compareTo(Music m){
            if(this.length == m.length){
                return this.start-m.start;
            } else{
                return m.length-this.length;
            }
        }
    }
}