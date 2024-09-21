import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // map 만들기
        int H = park.length;
        int W = park[0].length;
        Arrays.sort(mats);
        
        for(int k=mats.length-1; k>=0; k--){
            int mat = mats[k];
            for(int i=0; i<= H - mat; i++){
                for(int j=0; j<= W - mat; j++){
                    if(check(mat, i, j, park))
                        return mat; 
                }
            }    
        }
        return -1;
    }
    
    private boolean check(int mat, int x, int y, String[][] park){
        for(int i=x; i<x+mat; i++){
            for(int j=y; j<y+mat; j++){
                if(!park[i][j].equals("-1"))
                    return false;
            }
        }
        return true;
    }
}