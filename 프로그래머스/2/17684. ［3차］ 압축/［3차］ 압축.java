import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        
        // 사전
        Map<String, Integer> dict = new HashMap<>();
        int index = 27;
        
        for(int i=1; i<=26; i++){
            dict.put("" + (char)('A' + i - 1), i);
        }
        
        for(int i=0; i<msg.length(); i++){
            // 2. i부터 시작하는 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
            String w = msg.substring(i, i+1);
            int end = i;
            for(int j=i; j<msg.length(); j++){
                String t = msg.substring(i, j+1);
                if(dict.containsKey(t) && w.length() < t.length()){
                    w = t;
                    end = j;
                }
            }
            
            // System.out.println("w : " + w);
            
            // 3. w에 해당하는 색인 번호를 출력하고 입력에서 w를 제거한다.
            result.add(dict.get(w));
            
            // 4. 처리되지 않은 다음 글자가 남아있다면 해당하는 단어를 사전에 등록한다.
            if(end < msg.length() - 1){
                String wc = msg.substring(i, end+2);
                dict.put(wc, index++);
                // System.out.println("w + c : " + wc);
            }
            
            if(i < end)
                i = end;
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++)
            answer[i] = result.get(i);
        return answer;
    }
}