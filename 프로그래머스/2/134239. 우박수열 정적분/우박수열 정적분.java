import java.util.*;

class Solution {
    
    List<Long> arr = new ArrayList<>();
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        collatz(k);
        int n = arr.size() - 1;
        
        double[] nsum = new double[n];
        for(int i=0; i<n; i++){
            long y1 = arr.get(i);
            long y2 = arr.get(i+1);
            nsum[i] = (double) (y1 + y2) / 2;
        }
        for(int i=1; i<n; i++){
            nsum[i] += nsum[i-1];
        }
        for(int i=0; i<n; i++)
            System.out.println(nsum[i]);
        
        for(int i=0; i<ranges.length; i++){
            int a = ranges[i][0];
            int b = ranges[i][1];
            b = n + b;
            
            if(a > b){ 
                answer[i] = -1.0;
            } else if(a == b){
                answer[i] = 0.0;
            } else {
                if(b > 0)
                    b--;
                if(a > 0) {
                    a--;
                    answer[i] = nsum[b] - nsum[a];
                }
                else if(a == 0)
                    answer[i] = nsum[b];
            }
        }
        
        return answer;
    }
    
    public void collatz(int k){
        long t = (long) k;
        arr.add(t);
        while(t > 1){
            if(t % 2 == 0){
                t /= 2;
            } else {
                t *= 3;
                t += 1;
            }
            arr.add(t);
        }
    }
}