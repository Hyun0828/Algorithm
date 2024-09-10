class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        
        while(true){
            int r = max % min;
            if(r == 0)
                break;
            
            max = min;
            min = r;
        }
        
        answer[0] = min;
        answer[1] = m * n / min;
        
        return answer;
    }
}