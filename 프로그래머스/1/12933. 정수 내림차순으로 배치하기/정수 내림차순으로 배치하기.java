import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = Long.toString(n);
        char[] arr = s.toCharArray();
        int[] num = new int[arr.length];
        for(int i=0; i<arr.length; i++)
            num[i] = arr[i] - '0';
        Arrays.sort(num);
        
        for(int i=0;i<num.length;i++){
            answer += num[i] * Math.pow(10, i);
        }
        
        return answer;
    }
}