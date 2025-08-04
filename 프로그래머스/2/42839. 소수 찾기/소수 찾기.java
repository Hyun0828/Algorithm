import java.util.*;

class Solution {
    
    static Set<Integer> sVisited;
    static boolean[] visited;
    static char[] arr;
    static int len;
    static int answer;
    
    public int solution(String numbers) {
        sVisited = new HashSet<>();
        answer = 0;
        arr = numbers.toCharArray();
        visited = new boolean[numbers.length()];
        len = arr.length;
        
        permutation(0, "");
        return answer;
    }
    
    public static void permutation(int cnt, String s){
        if(cnt > len){
            return;
        }
        
        if(cnt >= 1 && !sVisited.contains(Integer.parseInt(s)) && isPrime(Integer.parseInt(s))){
            sVisited.add(Integer.parseInt(s));
            answer++;
        }
        
        for(int i=0; i<len; i++){
            if(visited[i])
                continue;
            
            visited[i] = true;
            permutation(cnt+1, s+arr[i]);
            visited[i] = false;
        }
    }
    
    public static boolean isPrime(int n){
        if(n<=1)
            return false;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}