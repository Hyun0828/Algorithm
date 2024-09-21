class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] temp = video_len.split(":");
        int video = Integer.parseInt(temp[0]) * 100 + Integer.parseInt(temp[1]);
        temp = pos.split(":");
        int current = Integer.parseInt(temp[0]) * 100 + Integer.parseInt(temp[1]);
        temp = op_start.split(":");
        int start = Integer.parseInt(temp[0]) * 100 + Integer.parseInt(temp[1]);
        temp = op_end.split(":");
        int end = Integer.parseInt(temp[0]) * 100 + Integer.parseInt(temp[1]);
        
        for(String command : commands){
            
            // 오프닝 건너뛰기
            if(current >= start && current <= end)
                current = end;
            
            // 기능
            if(command.equals("prev")){
                if(current < 10)
                    current = 0;
                else{
                    // 1300 -> 1250
                    // 1309 -> 1259
                    if(current%100 >= 0 && current%100 <= 9)
                        current -= 50;
                    else
                        current -= 10;
                }
            } else if(command.equals("next")){
                
                // video : 3000, current : 2950~2959
                // video : 3010, current : 3000~3010
                if(video%100 < 10 && video-current < 50)
                    current = video;
                else if(video - current < 10)
                    current = video;
                else{
                    if(current%100 >= 50 && current%100 <= 59)
                        current += 50;
                    else
                        current += 10;
                }
            }
            
            // 오프닝 건너뛰기
            if(current >= start && current <= end)
                current = end;
        }
        
        StringBuilder sb = new StringBuilder();
        String p = Integer.toString(current/100);
        String n = Integer.toString(current%100);
        if(current/100 < 10)
            sb.append(0).append(p);
        else
            sb.append(p);
        sb.append(":");
        if(current%100 < 10)
            sb.append(0).append(n);
        else
            sb.append(n);
        
        answer = sb.toString();
        
        return answer;
    }
}