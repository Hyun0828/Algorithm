import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        // 그냥 단순하게 큰 것만 터트리면, 무조건 가장 작은 숫자가 남게 된다
        // 그럼 작은 것을 터트리는 1번의 기회를 언제 쓰냐가 어떤 숫자가 남냐를 결정한다.
        
        // 가장 작은 숫자를 터트리려면 1번의 기회를 작은 숫자에 써야됨
        // 가장 작은 숫자가 아니라면, 그 숫자보다 더 작은 숫자랑 인접했을 때 큰 숫자 터트리기를 하면 없어진다.
        
        // -92가 아닌 숫자 입장에선, -92가 나보다 작은 숫자들은 다 날려줄 수 있다.
        // 그러고 나랑 -92가 남았을 때 1회 쓰면 된다.
        
        // -2 입장에서는 오른쪽은 -92가 다 날려서 -92만 남았는데 왼쪽은 -92가 못 날리고, -2보다 작은 -16이 있어서 실패
        
        // 가장 작은 숫자가 나의 오른쪽에 있을 때, 나의 왼쪽에 나보다 작은 숫자가 있으면 못 남는다.
        // 가장 작은 숫자가 나의 왼쪽에 있을 때, 나의 오른쪽에 나보다 작은 숫자가 있으면 못 남는다.
        
        // -16,27,65,-2,58,-92,-71,-68,-61,-33
        
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int[] dp1 = new int[a.length]; // dp1[i] : 0~i번째 인덱스에서의 최솟값
        int[] dp2 = new int[a.length]; // dp2[i] : i~ 에서의 최솟값
        for(int i=0; i<a.length; i++){
            dp1[i] = a[i];
            dp2[i] = a[i];
        }
        for(int i=a.length-2; i>=0; i--){
            dp2[i] = Math.min(dp2[i], dp2[i+1]);
        }
        
        for(int i=0; i<a.length; i++){
            if(min > a[i]){
                min = a[i];
                minIndex = i;
            }
            
            if(i > 0)
                dp1[i] = Math.min(dp1[i], dp1[i-1]);
        }
        
        for(int i=0; i<a.length; i++){
            if(i < minIndex){
                if(i == 0){
                    answer++;
                } else if(dp1[i - 1] > a[i]){
                    answer++;
                }
            } else if(i > minIndex) {
                if(i == a.length - 1){
                    answer++;
                } else if(dp2[i + 1] > a[i]){
                    answer++;
                }
            } else {
                answer++;
            }
        }
        
        
        
        return answer;
    }
}