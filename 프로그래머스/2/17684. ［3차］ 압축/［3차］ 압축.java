import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        // 사전 : Map<String, Integer> dict
        // 마지막 색인번호 : lastIndex
        
        // w를 찾는 로직 
        // 사전의 색인번호 : dict.get(w)
        // 입력에서 w를 제거하는건, 그냥 msg에서 pointer 업데이트
        // w 뒤에 문자가 남아 있으면, 사전에 등록 dict.add(w+c, lastIndex++);
        
        Map<String, Integer> dict = new HashMap<>();
        int lastIndex = 26;
        
        // 사전 초기화
        for(int i=0; i<26; i++){
            dict.put(String.valueOf((char)('A'+i)), i+1);
        }
        
        for(int i=0; i<msg.length(); i++){
            String findMsg = "";
            int end = i;
            for(int j=msg.length()-1; j>=i; j--){
                String sub = msg.substring(i, j+1);
                if(dict.containsKey(sub)){
                    findMsg = sub;
                    end = j;
                    break;
                }
            }
            
            // 색인 번호 출력
            int index = dict.get(findMsg);
            answer.add(index);
            
            // 입력 문자 제거
            i = end;
            
            // 뒤에 문자가 있으면 합쳐서 사전에 추가
            if(end <= msg.length() - 2){
                dict.put(findMsg + msg.charAt(end + 1), ++lastIndex);
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}