import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static char[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++)
            arr[i] = reader.readLine().toCharArray();

        // 적록색약이 없을 때
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, n);
                    count++;
                }
            }
        }
        System.out.print(count + " ");

        // 적록색약이 있을 때
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'G')
                    arr[i][j] = 'R';
                visited[i][j] = false;
            }
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, n);
                    count++;
                }
            }
        }
        System.out.print(count);
    }

    public static void DFS(int x, int y, int n) {

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= n)
                continue;
            if (!visited[next_x][next_y]) {
                if (arr[next_x][next_y] == arr[x][y])
                    DFS(next_x, next_y, n);
            }
        }
    }
}