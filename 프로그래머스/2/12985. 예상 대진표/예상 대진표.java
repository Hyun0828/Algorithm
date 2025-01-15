import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(n > 1){
            double k = Math.log(n) / Math.log(2);
            
            if(a <= n/2 && b <= n/2){
                n /= 2;
            } else if(a > n/2 && b > n/2){
                n /= 2;
                a -= n;
                b -= n;
            } else {
                answer = (int)k;
                break;
            }
        }
        
        return answer;
    }
}
