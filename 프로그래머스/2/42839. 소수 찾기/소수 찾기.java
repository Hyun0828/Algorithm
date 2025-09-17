import java.util.*;

class Solution {
    
    int answer = 0;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        permutation(numbers.toCharArray(), new boolean[numbers.length()], "");
        return answer;
    }
    
    public void permutation(char[] numbers, boolean[] visited, String number){
        if(!number.equals("") && isPrime(Integer.parseInt(number)) && !set.contains(Integer.parseInt(number))){
            answer++;
            set.add(Integer.parseInt(number));
        }
        
        if(number.length() == numbers.length){
            return;
        }
        
        for(int i=0; i<numbers.length; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            permutation(numbers, visited, number+numbers[i]);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int n){
        if(n <= 1)
            return false;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}