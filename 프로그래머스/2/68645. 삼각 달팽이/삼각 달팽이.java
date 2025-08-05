import java.util.*;

class Solution {
    
    int[][] map;
    boolean[][] visited;
    
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        
        map = new int[n][n];
        visited = new boolean[n][n];
        
        int count = 0;
        int y = 0;
        int x = 0;
        int direction = -1; // -1(아래), 0(오른쪽), 1(왼쪽 위)
        
        while (true) {
            if (count == n * (n + 1) / 2) {
                break;
            }
            map[y][x] = ++count;
            visited[y][x] = true;

            if (direction == -1) {
                if (y + 1 == n || visited[y + 1][x]) {
                    direction = 0;
                    x++;
                } else {
                    y++;
                }
            } else if (direction == 0) {
                if (x + 1 == n || visited[y][x + 1]) {
                    direction = 1;
                    y--;
                    x--;
                } else {
                    x++;
                }
            } else if (direction == 1) {
                if (visited[y - 1][x - 1]) {
                    direction = -1;
                    y++;
                } else {
                    y--;
                    x--;
                }
            }
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0)
                    answer[idx++] = map[i][j];
            }
        }
        
        return answer;
    }
}