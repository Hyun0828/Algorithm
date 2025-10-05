import java.util.*;

class Solution {
    
    char[][] map;
    int answer = 0;
    
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        for(int i=0; i<board.length; i++){
            map[i] = board[i].toCharArray();
        }
        
        while(erase(m, n)){
            down(m, n);
        }
        
        return answer;
    }
    
    public boolean erase(int m, int n){
        Set<String> set = new HashSet<>();
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                char c = map[i][j];
                if(c == 'z')
                    continue;
                if(map[i+1][j] == c && map[i][j+1] == c && map[i+1][j+1] == c){
                    String s = i + "," + j;
                    String s1 = (i+1) + "," + j;
                    String s2 = i + "," + (j+1);
                    String s3 = (i+1) + "," + (j+1);
                    set.add(s);
                    set.add(s1);
                    set.add(s2);
                    set.add(s3);
                }
            }
        }
        
        if(set.isEmpty())
            return false;
        
        for(String s : set){
            String[] t = s.split(",");
            int y = Integer.parseInt(t[0]);
            int x = Integer.parseInt(t[1]);
            map[y][x] = 'z';
            answer++;
        }
        return true;
    }
    
    public void down(int m, int n){
        for(int i=0; i<n; i++){
            for(int j=m-1; j>=0; j--){
                if(map[j][i] != 'z'){
                    for(int k=j+1; k<m; k++){
                        if(map[k][i] == 'z'){
                            map[k][i] = map[k-1][i];
                            map[k-1][i] = 'z';
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
}