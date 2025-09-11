import java.util.*;

class Solution {
    public int solution(int n, long l, long r) {        
        return func(n, l-1, r-1, 0, (long)Math.pow(5, n));        
    }
    
    public int func(int n, long l, long r, long start, long end){
        if(r < start || end - 1 < l) return 0; // 포함되지 않는 범위면
        if(n == 0) return 1; // 0번째 칸토어 비트열은 "1"
        
        long unit = (end - start) / 5; // 5등분 했을 때 한 단위의 크기
        int total = 0;
        for(int i=0; i<5; i++){
            if(i==2) // 5등분 영역 중 가운데는 0이다.
                continue;
            long tempS = start + unit * i;
            long tempE = tempS + unit;
            total += func(n-1, l, r, tempS, tempE);
        }
        return total;
    }
}