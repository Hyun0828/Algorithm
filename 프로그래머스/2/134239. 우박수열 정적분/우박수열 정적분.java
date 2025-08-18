import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        double[] result = collatz(k);
        int n = result.length;
        
        for(int i=0; i<ranges.length; i++){
            int a = ranges[i][0];
            int b = ranges[i][1];
            b = n + b;
            
            if(a > b){
                answer[i] = -1;
            } else if(a == b){
                answer[i] = 0;
            } else {
                if(b > 0)
                    b--;
                if(a > 0){
                    a--;
                    answer[i] = result[b] - result[a];
                } else if(a==0){
                    answer[i] = result[b];
                }
                    
                
            }
        }
        
        
        return answer;
    }
    
    public double[] collatz(int k){
        List<Double> result = new ArrayList<>();
        while(k > 1){
            int prev = k;
            if(k % 2 == 0){
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            int next = k;
            
            result.add((double)(prev+next) / 2);
        }
        
        double[] arr = new double[result.size()];
        arr[0] = result.get(0);
        for(int i=1; i<result.size(); i++){
            arr[i] = arr[i-1] + result.get(i);
        }
        return arr;
    }
}