class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length() == 4 || s.length() == 6){
            char[] arr = s.toCharArray();
            for(int i=0; i<arr.length; i++){
                if(!Character.isDigit(arr[i])){
                    answer = false;
                    break;
                }
                    
            }
        } else {
            answer = false;
        }
        
        return answer;
    }
}