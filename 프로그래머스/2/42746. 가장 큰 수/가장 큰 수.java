import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        Integer[] arr = new Integer[numbers.length];
        for(int i=0; i<arr.length; i++)
            arr[i] = numbers[i];
        
        Arrays.sort(arr, (a,b) -> {
            String s1 = a + "" + b;
            String s2 = b + "" + a;
            return s2.compareTo(s1);
        });
        
        if(arr[0] == 0)
            return "0";
        
        for(int i=0; i<arr.length; i++)
            answer += String.valueOf(arr[i]);
        
        return answer;
    }
}