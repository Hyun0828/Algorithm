import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> ans = new LinkedList<>();
        
        String[] temp = today.split("\\.");
        Integer limit_year = Integer.parseInt(temp[0]); // 2022
        Integer limit_month = Integer.parseInt(temp[1]); // 05
        Integer limit_day = Integer.parseInt(temp[2]); // 19
        Map<String, Integer> map = new HashMap<>();
        
        for(String t : terms){
            String[] s = t.split(" ");
            String term = s[0];
            Integer len = Integer.parseInt(s[1]);
            
            map.put(term, len);
        }
        
        for(int i=0; i<privacies.length; i++){
            String[] s = privacies[i].split(" ");
            String[] date = s[0].split("\\.");
            String term = s[1];
            
            int len = map.get(term); // 6
            
            int year = Integer.parseInt(date[0]); // 2021
            int month = Integer.parseInt(date[1]); // 05
            int day = Integer.parseInt(date[2]); // 02
            
            // 수집일자에서 1일을 먼저 뺀다.
            if(day==1){
                if(month==1){
                    year-=1;
                    month=12;
                    day=28;
                }
                else{
                    month-=1;
                    day=28;
                }
            } else {
                day-=1;
            }
            
            // 유효 기간을 계산한다.
            if(month + len > 12){
                if((month+len)%12 == 0){
                    year += (month+len)/12 - 1;
                    month = 12;
                } else {
                    year += (month+len)/12;
                    month = (month+len)%12;
                }
            } else {
                month+=len;
            }
            
            boolean isDeleted = false;
            
            // today보다 늦어야 파기 안 당함
            // today랑 비교한다.
            if(limit_year > year){
                isDeleted = true;
            }
            else if(limit_year == year){
                if(limit_month > month){
                    isDeleted = true;
                }
                else if(limit_month == month){
                    if(limit_day > day){
                        isDeleted = true;
                    }
                }
            }
            if(isDeleted)
                ans.add(i+1);
        }
        
        Collections.sort(ans);
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
    
        return answer;
    }
}