import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int h=citations[citations.length-1]; h>=0; h--){
            int count = citations.length - binary_search(citations, h);
            if(count >= h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
    

    public int binary_search(int[] citations, int h){
        int start = 0;
        int end = citations.length - 1;
        int index = 100000;
        
        while(start <= end){
            int mid = (start + end) / 2;
            
            if (citations[mid] >= h){
                end = mid - 1;
                index = Math.min(index, mid);
            } else {
                start = mid + 1;
            }
        }
        
        return index;
    }
}