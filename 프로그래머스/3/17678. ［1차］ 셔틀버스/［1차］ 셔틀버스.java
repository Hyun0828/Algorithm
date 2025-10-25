import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
         int answer = 0;
        
        // 일단 다 태우고 만약 버스에 자리가 있다면 버스 도착 시각
        // 버스에 자리가 없다면, 버스에 탄 사람 중 마지막에 탄 사람 시각에서 1분을 뺀다
        int[] times = new int[timetable.length];
        for(int i=0; i<times.length; i++){
            times[i] = convertToInt(timetable[i]);
        }
        Arrays.sort(times);
        boolean[] visited = new boolean[times.length];
        
        int busStopTime = convertToInt("09:00");
        for(int i=0; i<n; i++){
            int cnt = 0;
            int maxTime = 0;
            
            for(int j=0; j<times.length; j++){
                if(!visited[j] && times[j] <= busStopTime){
                    cnt++;
                    maxTime = times[j];
                    visited[j] = true;
                }

                if(cnt == m){
                    break;
                }
            }
            
            if(cnt < m){
                answer = busStopTime;
            } else if(cnt == m){
                answer = maxTime - 1;
            }
            // System.out.println(cnt + "," + convertToString(busStopTime) + "," + convertToString(answer));
            
            busStopTime += t;
        }
        
        return convertToString(answer);
    }
    
    public int convertToInt(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    public String convertToString(int time){
        String s = "";
        int q = time / 60;
        if(q < 10){
            s += "0";
            s += q;
            s += ":";
        } else {
            s += q;
            s += ":";
        }
        int r = time - q * 60;
        if(r < 10){
            s += "0";
            s += r;
        } else {
            s += r;
        }
        return s;
    }
}