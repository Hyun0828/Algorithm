import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {        
        int defaultTime = fees[0];
        int defaultPay = fees[1];
        int unitTime = fees[2];
        int unitPay = fees[3];
        
        // 차량번호 : 입/출 + 시각
        Map<Integer, InOut> map = new HashMap<>();
        // 차량번호 : 주차 시간
        Map<Integer, Integer> tmap = new TreeMap<>();
        // 차량번호 기억하기
        Set<Integer> set = new TreeSet<>();
        
        // 주차 시간 구하기
        for(int i=0; i<records.length; i++){
            String record = records[i];
            String[] temp = record.split(" ");
            
            int time = convert(temp[0]);
            int carNum = Integer.parseInt(temp[1]);
            String inout = temp[2];
            
            if (map.containsKey(carNum)) {
                int ptime = map.get(carNum).time;
                String pinout = map.get(carNum).inout;
                int timeSlice = time - ptime;
                
                tmap.put(carNum, tmap.getOrDefault(carNum, 0) + timeSlice);
                map.remove(carNum);
            } else {
                map.put(carNum, new InOut(time, inout));
            }
            set.add(carNum);
        }
        
        // 안 빠져나온 차가 있으면 23:59에 출차 처리
        for (int carNum : map.keySet()) {
            int inTime = map.get(carNum).time;
            int timeSlice = convert("23:59") - inTime;
            tmap.put(carNum, tmap.getOrDefault(carNum, 0) + timeSlice);
        }
        
        int[] answer = new int[set.size()];
        int idx = 0;
        // 누적 주차 시간에 대한 주차 요금 계산
        for (int carNum : tmap.keySet()) {
            int totalTime = tmap.get(carNum);
            if(totalTime > defaultTime){
                double n = (double)(totalTime - defaultTime) / unitTime;
                int totalPay = (int) (Math.ceil(n) * unitPay);
                answer[idx++] = defaultPay + totalPay;
            } else {
                answer[idx++] = defaultPay;
            }
        }
        
        return answer;
    }
    
    public static int convert(String hhmm){
        String[] s = hhmm.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    
    public static class InOut {
        int time;
        String inout;
        
        public InOut(int time, String inout){
            this.time = time;
            this.inout = inout;
        }
    }
}