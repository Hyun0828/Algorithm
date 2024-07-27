import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static Queue<Point> queue = new LinkedList<Point>();
    public static int[][] arr;
    public static int[][] t_arr;
    public static boolean[][] visited;
    public static int n;
    public static int m;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n][m];
        t_arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(input[j]);
        }

        makeWall(0);

        System.out.println(answer);
    }

    public static void BFS() {

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            if (m >= 0) System.arraycopy(arr[i], 0, t_arr[i], 0, m);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (t_arr[i][j] == 2)
                    queue.offer(new Point(i, j));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            visited[point.x][point.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && t_arr[nx][ny] == 0) {
                        t_arr[nx][ny] = 2;
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (t_arr[i][j] == 0)
                    result++;

        answer = Math.max(answer, result);
    }

    public static void makeWall(int cnt) {

        if (cnt == 3) {
            BFS();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    makeWall(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

