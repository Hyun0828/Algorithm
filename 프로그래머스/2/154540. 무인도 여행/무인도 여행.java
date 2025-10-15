import java.util.*;

class Solution {
    
    int N;
    int M;
    int[][] map;
    boolean[][] visited;
    
    public int[] solution(String[] maps) {
        List<Integer> result = new ArrayList<>();
        
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(maps[i].charAt(j) == 'X')
                    map[i][j] = 0;
                else
                    map[i][j] = maps[i].charAt(j) - '0';
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    int area = bfs(i, j);
                    result.add(area);
                    
                    System.out.println(i + "," + j + "," + map[i][j] + "," + area);
                }   
            }
        }
        
        if(result.size() == 0)
            return new int[]{-1};
        
        int[] answer = new int[result.size()];
        Collections.sort(result);
        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public int bfs(int y, int x){
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        queue.add(new int[]{y,x});
        visited[y][x] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            
            answer += map[cy][cx];
            
            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= N || nx >= M)
                    continue;
                if(map[ny][nx] == 0 || visited[ny][nx])
                    continue;
                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }
        return answer;
    }
}