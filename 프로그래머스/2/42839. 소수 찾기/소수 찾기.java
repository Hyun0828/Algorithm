import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
        
    public int solution(String numbers) {        
        char[] arr = numbers.toCharArray();
        permutation(arr, "");
        return set.size();
    }
    
    public void permutation(char[] arr, String s){

        if(!s.equals("") && isPrime(Integer.parseInt(s))){
            set.add(Integer.parseInt(s));
        }
        
        if(s.length() == arr.length)
            return;
        
        for(int i=0; i<arr.length; i++){
            if(visited.contains(i))
                continue;
            visited.add(i);
            permutation(arr, s + arr[i]);
            visited.remove(i);
        }
    }
    
    public boolean isPrime(int n){
        if(n <= 1)
            return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}