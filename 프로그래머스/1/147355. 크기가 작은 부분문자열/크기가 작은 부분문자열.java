class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        char[] tarr = t.toCharArray();
        int len = p.length();
        
        for(int i=0; i<=tarr.length - len; i++){
            StringBuilder tsb = new StringBuilder();
            
            for(int j=0; j<len; j++){
                tsb.append(tarr[i+j]);
            }
            
            if(Long.parseLong(tsb.toString()) <= Long.parseLong(p))
                answer++;
        }
        
        
        
        
        return answer;
    }
}