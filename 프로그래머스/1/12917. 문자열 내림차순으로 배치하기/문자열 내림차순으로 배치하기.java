import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] temp = s.toCharArray();
        char[] arr = new char[temp.length];
        Arrays.sort(temp);
        
        for(int i=0; i<temp.length; i++)
            arr[i] = temp[temp.length - 1 -i];
        
        answer = new String(arr);
        
        return answer;
    }
}