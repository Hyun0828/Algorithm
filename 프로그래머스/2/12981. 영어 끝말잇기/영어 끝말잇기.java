import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> history = new HashSet<>();
        int num_of_user = 1;
        int order = 1;
        
        history.add(words[0]);
        char[] before = words[0].toCharArray();
            
        for(int i=1; i<words.length; i++){
            char[] current = words[i].toCharArray();
    
            // 현재 단어에 대한 사용자 번호와 차례
            int current_user = i%n+1;
            int current_order = i/n+1;
            
            // 1글자인 단어는 탈락이다.
            if(current.length == 1){
                answer[0] = current_user;
                answer[1] = current_order;
                return answer;
            }
            // 이미 등장한 단어면 탈락이다.
            if(history.contains(words[i])){
                answer[0] = current_user;
                answer[1] = current_order;
                return answer;
            }
            // 문자가 연결되지 않으면 탈락이다.
            if(before[before.length-1] != current[0]){
                answer[0] = current_user;
                answer[1] = current_order;
                return answer;
            }
            
            history.add(words[i]);
            before = current;
        }
        

        return answer;
    }
}