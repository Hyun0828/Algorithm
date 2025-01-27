import java.util.*;

class Solution {
    
    private List<Integer> days = new ArrayList<>();
    
    public int[] solution(int[] progresses, int[] speeds) {
        init(progresses, speeds);
        return getResult();
    }
    
    public void init(int[] progresses, int[] speeds){
        int len = progresses.length;
        
        for(int i=0; i<len; i++){
            int progress = progresses[i];
            int speed = speeds[i];
            int day = (100 - progress) / speed;
            
            if((100 - progress) % speed != 0)
                day += 1;
            
            days.add(day);
        }
    }
    
    public int[] getResult(){
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<days.size(); i++){
            int day = days.get(i);
            int j = i + 1;
            int count = 1;
            
            while(j < days.size() && days.get(j) <= day){
                count++;
                j++;
            }
            
            result.add(count);
            i = j - 1;
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}