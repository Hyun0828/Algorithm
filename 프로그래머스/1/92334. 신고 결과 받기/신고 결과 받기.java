import java.util.*;

class Solution {
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int length = id_list.length;
        
        // indexing
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<length; i++)
            map.put(id_list[i], i);
        
        // 신고한 ID 저장
        List<Set<String>> list = new ArrayList<>();
        for(int i=0; i<length; i++)
            list.add(new HashSet<>());
        
        // 신고 당한 횟수 계산 + list 저장
        Map<String, Integer> count = new HashMap<>();
        for(int i=0; i<report.length; i++){
            String[] pair = report[i].split(" ");
            int idx = map.get(pair[0]);
            if (list.get(idx).add(pair[1])) {
                count.put(pair[1], count.getOrDefault(pair[1], 0) + 1);
            }
        }
        
        // k번 이상 신고 당한 사람 찾기
        List<String> overK = new LinkedList<>();
        for(String id : id_list){
            if (count.getOrDefault(id, 0) >= k)
                overK.add(id);
        }
        
        int[] answer = new int[length];
        for(int i=0; i<length; i++){
            for(String user : overK){
                if(list.get(i).contains(user))
                    answer[i]++;
            }
        }
        
        return answer;
    }
}