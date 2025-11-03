import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {                
        int sy = 30;
        int ey = 0;
        int sx = 30;
        int ex = 0;
        int cnt = 0;
        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock[i].length; j++){
                if(lock[i][j] == 0){
                    sy = Math.min(sy, i);
                    ey = Math.max(ey, i);
                    sx = Math.min(sx, j);
                    ex = Math.max(ex, j);
                    cnt++;
                }
            }
        }
        if(cnt == 0)
            return true;
        
        
        int[][] target = new int[ey-sy+1][ex-sx+1];
        for(int i=sy; i<=ey; i++){
            for(int j=sx; j<=ex; j++){
                if(lock[i][j] == 0)
                    target[i-sy][j-sx] = 1;
                else
                    target[i-sy][j-sx] = 0;
            }
        }
        int ty = ey-sy+1;
        int tx = ex-sx+1;
        
        boolean canOpen = false;
        for(int k=0; k<4; k++){
            canOpen = match(target, key, ty, tx);
            if(canOpen)
                break;
            // 회전
            key = rotate(key);
        }
        
        return canOpen;
    }
    
    // 시계방향 90도 회전
    public int[][] rotate(int[][] key){
        int n = key.length;
        int[][] temp = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                temp[i][j] = key[n-(j+1)][i];
            }
        }
        return temp;
    }
    
    public boolean match(int[][] target, int[][] key, int ty, int tx){
        if (key.length < ty || key.length < tx) {
            return false;
        }
        
        for(int i=0; i<key.length-ty+1; i++){
            for(int j=0; j<key.length-tx+1; j++){
                // i,j를 시작 기준으로 비교
                boolean canOpen = true;
                for(int y=0; y<ty; y++){
                    for(int x=0; x<tx; x++){
                        if(target[y][x] != key[i+y][j+x]){
                            canOpen = false;
                            break;
                        }
                    }
                    if(!canOpen)
                        break;
                }
                if(canOpen){
                    return true;
                }
            }
        }
        return false;
    }
}