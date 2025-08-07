class Solution {
    public int solution(int storey) {
        int count = 0;
        
        while (storey > 0) {
            int n = storey % 10;
            storey /= 10;
            
            if(n < 5) {
                count += n;
                continue;
            }
            
            if(n == 5){
                int m = storey % 10;
                if(m + 1 > 5){
                    storey += 1;
                    count += (10 - n);
                    continue;
                } else {
                    count += n;
                    continue;
                }
            }
            
            if(n > 5){
                storey += 1;
                count += (10-n);
            }
        }
        
        return count;
    }
}