class Solution {
    public int solution(int num) {
        int answer = 0;
        long N = num;
        
        while(N != 1){
            if(N % 2 == 0)
                N /= 2;
            else
                N = N * 3 + 1;
            answer++;
            
            if(answer > 500){
                answer = -1;
                break;
            }
        }
    
        
        return answer;
    }
}