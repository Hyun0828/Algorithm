import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();
        
        // 1 2 3
        // 2 2 3
        // 3 3 3
        
        // 1 2 3 4
        // 2 2 3 4
        // 3 3 3 4
        // 4 4 4 4
        
        // n이 존나 크니까 직접 배열을 만들지는 않을거고, 뭔가 인덱스 규칙을 찾는다거나 하겠지?
        // n은 (i,j)에서 i나 j가 n-1이면서 n보다 작은 숫자네
        
        // 생각을 해보면 left~right가 몇번째행, 몇번째열인지 구하면 된다.
        // left -> left/n행, left-left/n*n열
        
        // 그럼 만약에 left, right가 같은 행이면 같은 열의 숫자만 저장하면 되고
        // 다른 행이면 left행 끝까지 + left-right 중간 행 전부 + right 행 왼쪽만 저장
        
        long ly = left / n;
        long lx = left - (left/n) * n;
        long ry = right / n;
        long rx = right - (right/n) * n;
        
        if(ly == ry){
            for(long j=lx; j<=rx; j++){
                answer.add((int)Math.max(ly+1, j+1));
            }
        } else {
            for(long j=lx; j<n; j++)
                answer.add((int)Math.max(ly+1, j+1));
            
            for(long i=ly+1; i<ry; i++){
                for(long j=0; j<n; j++)
                    answer.add((int)Math.max(i+1, j+1));
            }
            
            for(long j=0; j<=rx; j++)
                answer.add((int)Math.max(ry+1, j+1));
        }
        
        int[] result = new int[answer.size()];
        for(int i=0; i<result.length; i++)
            result[i] = answer.get(i);
        return result;
    }
}