class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        
        
        if(arr.length % 2 == 0){
            char[] narr = new char[2];
            narr[0] = arr[arr.length / 2 - 1];
            narr[1] = arr[arr.length / 2];
            
            answer = new String(narr);
        } else{
            char[] narr = new char[1];
            narr[0] = arr[arr.length / 2];
            
            answer = new String(narr);
        }
        
        return answer;
    }
}