import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int[] arr1 = new int[sequence.length];
        int[] arr2 = new int[sequence.length];
        int n1 = 1;
        int n2 = -1;
        for(int i=0; i<sequence.length; i++){
            arr1[i] = sequence[i] * n1;
            n1 *= -1;
            arr2[i] = sequence[i] * n2;
            n2 *= -1;
        }
        
        return Math.max(solve(arr1), solve(arr2));
    }
    
    // 2 -3 -6 -1 3 1 2 -4
    // -2 3 6 1 -3 -1 -2 4
    
    public long solve(int[] arr){
        long max = arr[0];
        long current = arr[0];
        
        for(int i=1; i<arr.length; i++){
            current = Math.max(arr[i], current + arr[i]);
            max = Math.max(current, max);
        }
        
        return max;
    }
}