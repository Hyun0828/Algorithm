import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String s = Integer.toString(n, k);
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                String sub = s.substring(i, j);
                
                if(isPrime(Long.parseLong(sub)) && !hasZero(sub)){
                    System.out.println(i + ", " + j + ", " + sub);
                    if(i==0 && j==s.length()){
                        System.out.println("P : " + sub);
                        answer++;
                    } else if(i > 0 && j < s.length() && s.charAt(i-1) == '0' && s.charAt(j) == '0'){
                        System.out.println("0P0 : " + sub);
                        answer++;
                    } else if(i == 0 && j < s.length() && s.charAt(j) == '0'){
                        System.out.println("P0 : " + sub);
                        answer++;
                    } else if(i > 0 && j == s.length() && s.charAt(i-1) == '0'){
                        System.out.println("0P : " + sub);
                        answer++;
                    } 
                }
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long num){
        if(num <= 1)
            return false;
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
    
    public boolean hasZero(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0')
                return true;
        }
        return false;
    }
}