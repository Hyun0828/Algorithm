class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] sarr = s.split(" ", -1);
        for(int j=0; j<sarr.length; j++){
            char[] arr = sarr[j].toCharArray();
            for(int i=0; i<arr.length; i++){
                if(i%2==0)
                    arr[i] = Character.toUpperCase(arr[i]);
                else
                    arr[i] = Character.toLowerCase(arr[i]);
            }
            sb.append(new String(arr));
            if(j < sarr.length - 1)
                sb.append(" ");
        }
        
        String answer = sb.toString();
        return answer;
    }
}