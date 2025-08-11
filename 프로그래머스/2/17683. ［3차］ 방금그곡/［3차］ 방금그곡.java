import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        String cm = convert(m);
        int resTime = 0;
        int staTime = 10000000;
        
        // System.out.println("cm : " + cm);

        for(int i=0; i<musicinfos.length; i++){
            String[] s = musicinfos[i].split(",");
            int playTime = getPlayTime(s[0], s[1]);
            String name = s[2];
            String shortMusic = convert(s[3]);
                        
            if(playTime < cm.length())
                continue;
            
            String totalMusic = "";
            for(int j=0; j<playTime / shortMusic.length(); j++){
                totalMusic += shortMusic;
            }
            int mod = playTime % shortMusic.length();
            totalMusic += shortMusic.substring(0, mod);
            
            // System.out.println(totalMusic);
            
            if(totalMusic.contains(cm)){
                if(resTime <= playTime){
                    if(resTime == playTime){
                        if(staTime > Integer.parseInt(s[0].split(":")[0]) * 60){
                            answer = name;
                            resTime = playTime;
                            staTime = Integer.parseInt(s[0].split(":")[0]) * 60;
                        }
                    } else {
                        answer = name;
                        resTime = playTime;
                        staTime = Integer.parseInt(s[0].split(":")[0]) * 60;
                    }
                }
            }
        }
        
        return answer;
    }
    
    public static int getPlayTime(String start, String end){
        String[] st = start.split(":");
        int s = Integer.parseInt(st[0]) * 60 + Integer.parseInt(st[1]);
        String[] et = end.split(":");
        int e = Integer.parseInt(et[0]) * 60 + Integer.parseInt(et[1]);
        return e - s;
    }
    
    public static String convert(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(i==s.length()-1){
                sb.append(c);
                continue;
            }
            char n = s.charAt(i+1);
            
            if(n == '#'){
                sb.append(Character.toLowerCase(c));
                i++;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}