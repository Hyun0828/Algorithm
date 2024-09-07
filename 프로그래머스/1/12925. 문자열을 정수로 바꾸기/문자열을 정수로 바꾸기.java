class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] arr = s.toCharArray();
        
        if(arr[0] == '+'){
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<arr.length; i++)
                sb.append(arr[i]);
            String newString = sb.toString();
            answer = Integer.parseInt(newString);
        } else if(arr[0] == '-'){
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<arr.length; i++)
                sb.append(arr[i]);
            String newString = sb.toString();
            answer = Integer.parseInt(newString) * (-1);
        } else {
            answer = Integer.parseInt(s);
        }
        
        return answer;
    }
}