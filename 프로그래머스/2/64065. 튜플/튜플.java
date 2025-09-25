import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        List<Set<Integer>> list = new ArrayList<>();

        // 걍 집합 표기에 대해 숫자 개수로 오름차순 정렬하고, 왼쪽부터 순서를 올바르게 하나씩 넣기
        String[] temp = s.substring(2, s.length()-2).split("\\},\\{");
        for(int i=0; i<temp.length; i++){
            String[] tmp = temp[i].split(",");
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<tmp.length; j++)
                set.add(Integer.parseInt(tmp[j]));
            list.add(set);
        }
        Collections.sort(list, (a,b) -> a.size() - b.size());
        int[] answer = new int[list.size()];
        Set<Integer> a = list.get(0);
        Set<Integer> t = new HashSet<>(a);
        for(Integer i : a)
            answer[0] = i;
        
        for(int i=1; i<list.size(); i++){
            Set<Integer> b = list.get(i);
            b.removeAll(t);
            for(Integer j : b){
                answer[i] = j;
                t.add(j);
            }
        }
        
        return answer;
    }
}