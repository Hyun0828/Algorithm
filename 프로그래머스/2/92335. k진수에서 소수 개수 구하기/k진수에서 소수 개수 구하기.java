import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        
        for (int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                String sub = s.substring(i, j+1);
                long num = Long.parseLong(sub);
                if(num == 1)
                    continue;
                
                if(isPrime(num) && hasZero(sub) && isOk(i, j, s)){
                    System.out.println(num);
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public static boolean isPrime(long n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
    
    public static boolean hasZero(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0')
                return false;
        }
        return true;
    }
    
    public static boolean isOk(int start, int end, String s){

        if(start == 0 && end == s.length()-1){
            return true;
        }
        
        if(start == 0 && end < s.length() - 1){
            if(s.charAt(end+1) == '0')
                return true;
        }
        
        if(start > 0 && end == s.length() -1) {
            if(s.charAt(start-1) == '0')
                return true;
        }
        
        if(start > 0 && end < s.length() - 1){
            if(s.charAt(start-1) == '0' && s.charAt(end+1) == '0')
                return true;
        }
        
        return false;
    }
}