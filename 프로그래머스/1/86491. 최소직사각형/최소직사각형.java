import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int[] width = new int[sizes.length];
        int[] height = new int[sizes.length];
        
        for(int i=0; i<sizes.length; i++){
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            width[i] = Math.max(w, h);
            height[i] = Math.min(w, h);
        }
        
        Arrays.sort(width);
        Arrays.sort(height);
        
        
        return width[sizes.length-1] * height[sizes.length-1];
    }
}