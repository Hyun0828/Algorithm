import java.util.*;

class Solution {

    public long solution(int n) {    
        long[] arr = new long[n+1];
        if(n>1)
            dp(arr, n);
        else   
            arr[1] = 1;
        return arr[n];
    }
    
    public void dp(long[] arr, int n){
        arr[1] = 1;
        arr[2] = 2;
        
        for(int i=3; i<=n; i++){
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] %= 1234567;
        }
    }
}