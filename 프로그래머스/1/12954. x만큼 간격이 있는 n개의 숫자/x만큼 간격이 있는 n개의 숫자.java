class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int term = x;
        long X = x;
        
        for(int i=0; i<n; i++){
            answer[i] = X;
            X += term;
        }
        
        return answer;
    }
}