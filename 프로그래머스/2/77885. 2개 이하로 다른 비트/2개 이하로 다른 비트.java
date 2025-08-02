import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
    
        for(int i=0; i<numbers.length; i++){
            long number = numbers[i];
            if(number % 2 == 0){
                answer[i] = number + 1;
                continue;
            }
            
            char[] arr = Long.toString(number, 2).toCharArray();
            boolean flag = false;
            for(int j=arr.length-1; j>=0; j--){
                if(arr[j] == '0'){
                    arr[j] = '1';
                    arr[j+1] = '0';
                    flag = true;
                    break;
                }
            }
            
            char[] temp = new char[arr.length+1];
            if(!flag){
                temp[0] = '1';
                temp[1] = '0';
                for(int j=2; j<temp.length; j++){
                    temp[j] = arr[j - 1];
                }
                
                String s = new String(temp);
                answer[i] = Long.parseLong(s, 2);
            } else {
                String s = new String(arr);
                answer[i] = Long.parseLong(s, 2);
            }
        }
        
        return answer;
    }
}