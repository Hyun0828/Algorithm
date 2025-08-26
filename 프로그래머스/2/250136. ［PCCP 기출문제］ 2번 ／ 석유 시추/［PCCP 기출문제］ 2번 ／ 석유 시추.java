import java.util.*;

class Solution {
    
    static int groupNum;
    static Map<Integer, Integer> groupSize;
    
    public int solution(int[][] land) {
        int answer = 0;
        int Y = land.length;
        int X = land[0].length;
        // Gas[][] map = new Gas[Y][X];
        int[][] map = new int[Y][X];
        boolean[][] visited = new boolean[Y][X];
        groupNum = 1;
        groupSize = new HashMap<>();
        // bfs로 각 석유 그룹의 크기를 각각 구한다.
        // 시추관이 파고드는 열에서 지나가는 석유 그룹의 크기를 더한다.
        // 500번 반복한다.
        // for(int i=0; i<Y; i++){
            // for(int j=0; j<X; j++){
                // map[i][j] = new Gas(0, 0);
            // }
        // }
        
        for(int i=0; i<Y; i++){
            for(int j=0; j<X; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    bfs(land, map, visited, Y, X, i, j);
                }
            }
        }
                
        for(int i=0; i<X; i++){
            Set<Integer> groups = new HashSet<>();
            int result = 0;
            for(int j=0; j<Y; j++){
                // int group = map[j][i].group;
                // int value = map[j][i].value;
                int group = map[j][i];
                
                if(group == 0)
                    continue;
                if(!groups.contains(group)){
                    groups.add(group);
                    // result += value;
                    result += groupSize.get(group);
                }
            }
            answer = Math.max(answer, result);
        }
        
        return answer;
    }
    
    public static void bfs(int[][] land, int[][] map, boolean[][] visited, int Y, int X, int y, int x){
        int[] dx = {-1, 1, 0 ,0};
        int[] dy = {0, 0, 1, -1};
        
        int cnt = 0;
        List<Point> arr = new ArrayList<>();
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(y, x));
        
        while(!queue.isEmpty()){
            Point current = queue.poll();
            int cy = current.y;
            int cx = current.x;
            
            if(visited[cy][cx])
                continue;
            visited[cy][cx] = true;
            
            cnt++;
            arr.add(new Point(cy, cx));
            
            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                if(ny < 0 || ny >= Y || nx < 0 || nx >= X)
                    continue;
                if(visited[ny][nx])
                    continue;
                if(land[ny][nx] == 0)
                    continue;
                
                queue.add(new Point(ny, nx));
            }
        }
        
        for(Point p : arr){
            // map[p.y][p.x] = new Gas(groupNum, cnt);
            map[p.y][p.x] = groupNum;
        }        
        groupSize.put(groupNum, cnt);
        groupNum++;
    }
    
    public static class Point {
        int y;
        int x;
        
        public Point(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
    
//     public static class Gas {
//         int group;
//         int value;
        
//         public Gas(int group, int value){
//             this.group = group;
//             this.value = value;
//         }
//     }
}