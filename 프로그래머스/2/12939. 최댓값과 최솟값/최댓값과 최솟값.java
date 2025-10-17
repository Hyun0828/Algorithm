import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] t = s.split(" ");
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<t.length; i++){
            min.add(Integer.parseInt(t[i]));
            max.add(Integer.parseInt(t[i]));
        }
        answer += min.poll();
        answer += " ";
        answer += max.poll();
        
        return answer;
    }
}