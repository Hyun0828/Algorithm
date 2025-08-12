import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int sum = 0;
    
    public int[] solution(String[] maps) {
        List<Integer> result = new ArrayList<>();

        int Y = maps.length;
        int X = maps[0].length();
        int[][] map = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (maps[i].charAt(j) == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Integer.parseInt(maps[i].charAt(j) + "");
                }
            }
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (map[i][j] != 0) {
                    dfs(map, i, j, Y, X);
                    result.add(sum);
                    sum = 0;
                }
            }
        }

        if(result.isEmpty())
            return new int[]{-1};
        
        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void dfs(int[][] map, int y, int x, int Y, int X) {
        if (y < 0 || y >= Y || x < 0 || x >= X || map[y][x] == 0) {
            return;
        }

        sum += map[y][x];
        map[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            dfs(map, y + dy[i], x + dx[i], Y, X);
        }
    }
}