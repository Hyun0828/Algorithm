import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int i=citations[citations.length-1]; i>=0; i--){
            int index = binarySearch(citations, i);
            int count = citations.length - index;
            
            if(count >= i){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public int binarySearch(int[] citations, int h){
        int start = 0;
        int end = citations.length;
        int answer = 0;
        
        while(start <= end){
            int mid = (start + end) / 2;
            
            if(citations[mid] >= h){
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}