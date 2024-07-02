import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int max;
    public static int sum;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        arr = new int[n][m];
        visited = new boolean[n][m];
        max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = new int[m];
            visited[i] = new boolean[m];
            String[] num = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(num[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum = 0;
                visited[i][j] = true;
                DFS(m, n, i, j, 1);
                Except(m, n, i, j);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    public static void Except(int m, int n, int x, int y) {
        int sum = arr[x][y];
        int num = 0;
        int result = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                sum += arr[nx][ny];
                num++;
            }
        }

        if (num == 3) {
            result = sum;
        } else if (num == 4) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                result = Math.max(result, sum - arr[nx][ny]);
            }
        }
        max = Math.max(result, max);
    }

    public static void DFS(int m, int n, int x, int y, int cnt) {
        sum += arr[x][y];

        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])
                continue;

            visited[nx][ny] = true;
            DFS(m, n, nx, ny, cnt + 1);
            sum -= arr[nx][ny];
            visited[nx][ny] = false;
        }
    }
}
