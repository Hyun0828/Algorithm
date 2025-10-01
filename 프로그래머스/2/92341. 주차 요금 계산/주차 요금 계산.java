import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        // 차량번호 : 입차시각
        Map<Integer, Integer> parking = new HashMap<>();
        // 차량번호 : 총 주차시간
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String record : records){
            String[] tmp = record.split(" ");
            int time = convertTime(tmp[0]);
            int carNumber = Integer.parseInt(tmp[1]);
            if(tmp[2].equals("IN")){
                parking.put(carNumber, time);
            } else {
                int enterTime = parking.get(carNumber);            
                map.put(carNumber, map.getOrDefault(carNumber, 0) + time - enterTime);
                parking.remove(carNumber);
            }
        }
        
        // 출차 기록이 없는 차량 -> 23:59 출차로 판단
        for(Integer carNumber : parking.keySet()){
            int startTime = parking.get(carNumber);
            int endTime = convertTime("23:59");
            map.put(carNumber, map.getOrDefault(carNumber, 0) + endTime - startTime);
        }
        
        Map<Integer, Integer> result = new TreeMap<>();
        for(Integer carNumber : map.keySet()){
            result.put(carNumber, calculate(fees, map.get(carNumber)));
        }
        int[] answer = new int[result.size()];
        int idx = 0;
        for(Integer k : result.keySet()){
            answer[idx++] = result.get(k);
        }
        
        return answer;
    }
    
    public int convertTime(String t){
        String[] tmp = t.split(":");      
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
    
    public int calculate(int[] fees, int time){
        int money = 0;
        
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if(time <= defaultTime)
            return defaultFee;
        time -= defaultTime;
        money += defaultFee;
        money += (int) (Math.ceil(time / (double)unitTime) * unitFee);
        
        return money;
    }
}