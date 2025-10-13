import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(isOk(stones, k, mid)){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    
        return left;
    }
    
    public boolean isOk(int[] stones, int k, int n){
        int cnt = 0;
        for(int i=0; i<stones.length; i++){
            if(stones[i] - n <= 0)
                cnt++;
            else 
                cnt=0;
            
            if(cnt >= k)
                return false;
        }
        return true;
    }
}