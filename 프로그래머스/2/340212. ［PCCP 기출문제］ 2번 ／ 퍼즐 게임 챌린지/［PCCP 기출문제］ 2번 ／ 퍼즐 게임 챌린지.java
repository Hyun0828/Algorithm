import java.util.*;

class Solution {
    
    int answer = 400000;
    
    public int solution(int[] diffs, int[] times, long limit) {
        // 숙련도의 범위 : 1 or diffs의 최솟값 - 1 ~ diffs의 최댓값
        // 숙련도가 크면 클수록 당연히 총 소요시간은 짧아진다.
        // 완전탐색 300,000 * 300,000 니까 시간초과
        // Parametric Search?
        // O(log300,000 * 300,000)
        
        int[] temps = new int[diffs.length];
        for(int i=0; i<temps.length; i++)
            temps[i] = diffs[i];
        Arrays.sort(temps);
        parametricSearch(diffs, times, limit, temps[0], temps[temps.length-1]);
        return answer;
    }
    
    public void parametricSearch(int[] diffs, int[] times, long limit, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            long time = 0L;
            
            for(int i=0; i<diffs.length; i++){
                if(diffs[i] > mid){
                    int n = diffs[i] - mid;
                    time += (times[i-1] + times[i]) * n;
                    time += times[i];
                } else {
                    time += times[i];
                }
            }
            
            if(time <= limit){
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }
}