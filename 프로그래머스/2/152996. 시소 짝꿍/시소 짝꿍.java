import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        
        for(int weight : weights){
            double[] ratios = {1.0, 2.0/3.0, 1.0/2.0, 3.0/4.0};
            
            for(double r : ratios){
                double key = weight * r;
                if(map.containsKey(key))
                    answer += map.get(key);
            }
            map.put((double) weight, map.getOrDefault((double)weight, 0) + 1);
        }
        return answer;
    }
}