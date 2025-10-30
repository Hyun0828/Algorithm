import java.util.*;

class Solution {
    
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        int n = storage.length;
        int m = storage[0].length();
        char[][] map = new char[n][m];
        for(int i=0; i<n; i++){
            map[i] = storage[i].toCharArray();
        }
        
        for(int i=0; i<requests.length; i++){
            if(requests[i].length() == 1){
                // 접근 가능한 컨테이너만 꺼낸다
                getPossibleContainer(map, n, m, requests[i].charAt(0));
            } else {
                // 모든 컨테이너를 꺼낸다
                getAllContainer(map, n, m, requests[i].charAt(0));
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] != 'o')
                    answer++;
            }
        }
        
        return answer;
    }
    
    public boolean dfs(char[][] map, boolean[][] visited, int n, int m, int y, int x){
        if(y < 0 || x < 0 || y >= n || x >= m)
            return false;
        
        if(map[y][x] != 'o' || visited[y][x])
            return false;
        
        visited[y][x] = true;
        
        if(y == 0 || x == 0 || y == n - 1 || x == m - 1)
            return true;
        
        for(int i=0; i<4; i++){
            if(dfs(map, visited, n, m, y + dy[i], x + dx[i])){
                return true;
            }
        }
        return false;
    }
    
    public void getPossibleContainer(char[][] map, int n, int m, char target){
        Set<int[]> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == target){
                    // 테두리에 있는가
                    if(i == 0 || j == 0 || i == n - 1 || j == m - 1)
                        set.add(new int[]{i, j});
                    // 4면 중 하나가 외부인가
                    else if(i >= 0 && i < n && j >= 0 && j < m){
                        if(map[i+1][j] == 'o' && dfs(map, new boolean[n][m], n, m, i+1, j)){
                            set.add(new int[]{i, j});
                        } else if(map[i][j+1] == 'o' && dfs(map, new boolean[n][m], n, m, i, j+1)){
                            set.add(new int[]{i, j});
                        } else if(map[i-1][j] == 'o' && dfs(map, new boolean[n][m], n, m, i-1, j)){
                            set.add(new int[]{i, j});
                        } else if(map[i][j-1] == 'o' && dfs(map, new boolean[n][m], n, m, i, j-1)){
                            set.add(new int[]{i, j});
                        }
                    }
                }
            }
        }
        
        for(int[] cur : set){
            int y = cur[0];
            int x = cur[1];
            map[y][x] = 'o';
        }
    }
    
    public void getAllContainer(char[][] map, int n, int m, char target){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == target){
                    map[i][j] = 'o';
                }
            }
        }
    }
}