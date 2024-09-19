class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int H = wallpaper.length;
        int W = wallpaper[0].length();
        char[][] map = new char[H][W];
        
        for(int i=0; i<H; i++){
            map[i] = wallpaper[i].toCharArray();
        }
        
        int min_x = 100;
        int min_y = 100;
        int max_x = -1;
        int max_y = -1;
        
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(map[i][j]=='#'){
                    min_x = Math.min(min_x, i);
                    max_x = Math.max(max_x, i);
                    min_y = Math.min(min_y, j);
                    max_y = Math.max(max_y, j);
                }
            }
        }
        
        answer[0] = min_x;
        answer[1] = min_y;
        answer[2] = max_x + 1;
        answer[3] = max_y + 1;
        
        return answer;
    }
}