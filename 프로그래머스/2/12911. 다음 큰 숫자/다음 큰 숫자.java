import java.util.*;

class Solution {
    public int solution(int n) {        
        String binary1 = Integer.toBinaryString(n);
        int count1 = get1Count(binary1);
        
        int m = n + 1;
        while(true){
            String binary2 = Integer.toBinaryString(m);
            int count2 = get1Count(binary2);
            if(count1 == count2)
                break;
            m++;
        }
        
        return m;
    }
    
    public int get1Count(String n){
        int count = 0;
        for(int i=0; i<n.length(); i++){
            if(n.charAt(i) == '1')
                count++;
        }
        return count;
    }
}