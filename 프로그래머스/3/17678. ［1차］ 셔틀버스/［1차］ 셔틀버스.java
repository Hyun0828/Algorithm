import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;
        
        // 마지막 버스에 대해 버스가 꽉차면 마지막에 타는 사람 시각 -1분
        // 버스에 자리가 남으면 버스 도착 시각
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<timetable.length; i++){
            pq.add(toInt(timetable[i]));
        }
        
        int currentTime = toInt("09:00");
        for(int i=1; i<=n; i++){
            int M = m;
            int lastPerson = currentTime;
            
            while(!pq.isEmpty()){
                if(currentTime >= pq.peek() && M > 0){
                    M--;
                    lastPerson = pq.poll();
                } else {
                    break;
                }
            }
            
            if(i == n){
                if(M == 0){
                    answer = lastPerson - 1;
                } else {
                    answer = currentTime;
                }
            }
            
            currentTime += t;
        }
        return toString(answer);
    }
    
    public int toInt(String time){
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
    
    public String toString(int time){
        StringBuilder sb = new StringBuilder();
        int hour = time / 60;
        int minute = time % 60;
        
        if(hour < 10)
            sb.append('0');
        sb.append(String.valueOf(hour));
        sb.append(":");
        if(minute < 10)
            sb.append('0');
        sb.append(String.valueOf(minute));
        
        return sb.toString();
    }
}