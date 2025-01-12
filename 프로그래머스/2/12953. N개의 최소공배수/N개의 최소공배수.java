import java.util.*;

class Solution {
    public int solution(int[] arr) {
        // 어차피 최소공배수는 n의 배수니까 최댓값의 배수를 하면서 확인하면 젤 빠르겠지?
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        
        int mul=1;
        while(true){
            int new_max = max * mul;
            boolean flag = true;
            for(int i=0; i<arr.length; i++){
                if(new_max % arr[i] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                break;
            } else {
                mul++;
            }
        }
        
        return max * mul;
    }
}