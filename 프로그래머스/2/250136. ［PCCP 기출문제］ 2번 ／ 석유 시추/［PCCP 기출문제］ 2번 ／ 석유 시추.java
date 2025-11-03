import java.util.*;

class Solution {
    
    int[][] map;
    boolean[][] visited;
    Map<Integer, Integer> areaMap = new HashMap<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        int m = land[0].length;
        map = new int[n][m];
        visited = new boolean[n][m];
        int areaIdx = 1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    int cnt = bfs(land, n, m, i, j, areaIdx);
                    areaMap.put(areaIdx, cnt);
                    areaIdx++;
                }
            }
        }
        
        for(int i=0; i<m; i++){
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            for(int j=0; j<n; j++){
                if(map[j][i] > 0){
                    set.add(map[j][i]);
                }
            }
            for(Integer idx : set){
                sum += areaMap.get(idx);
            }
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    public int bfs(int[][] land, int n, int m, int y, int x, int areaIdx){
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        
        queue.add(new int[]{y, x});
        map[y][x] = areaIdx;
        visited[y][x] = true;
        int count = 1;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            
            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if(land[ny][nx] == 0 || visited[ny][nx])
                    continue;
                
                queue.add(new int[]{ny,nx});
                map[ny][nx] = areaIdx;
                visited[ny][nx] = true;
                count++;
            }
        }
        
        return count;
    }
}