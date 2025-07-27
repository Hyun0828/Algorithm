import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        int mainBelt = 1;
        Stack<Integer> subBelt = new Stack<>();
        
        for(int i=0; i<n; i++) {
            int box = order[i];
            
            // 메인 벨트에서 꺼낼 수 있으면
            if(mainBelt == box) {
                mainBelt++;
                answer++;
                continue;
            }
            
            // 보조 벨트에서 꺼낼 수 있으면
            if(!subBelt.isEmpty() && subBelt.peek() == box) {
                subBelt.pop();
                answer++;
                continue;
            }
            
            // 컨테이너 벨트의 맨 앞에 놓인 상자가 현재 트럭에 실어야 하는 순서가 아니라면 보조 컨테이너 벨트에 둔다.
            if(mainBelt != box) {
                // 꺼낼 수가 없으면 끝
                if(!subBelt.isEmpty() && subBelt.peek() > box){
                    break;
                }
                subBelt.push(mainBelt++);
                i--;
                continue;
            }
        }
        
        return answer;
    }
}