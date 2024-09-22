import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] temp = s.split(" ");
        int[] arr = new int[temp.length];
        
        for(int i=0; i<arr.length; i++)
            arr[i] = Integer.parseInt(temp[i]);
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ").append(arr[arr.length-1]);
        answer = sb.toString();
        
        return answer;
    }
}