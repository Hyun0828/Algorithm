import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<Point> queue = new LinkedList<Point>();
    static char[][] arr;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new char[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            arr[i] = reader.readLine().toCharArray();
            visited[i] = new boolean[m][2];
            for (int j = 0; j < m; j++)
                visited[i][j] = new boolean[2];
        }

        BFS();


    }

    private static void BFS() {

        queue.offer(new Point(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == n - 1 && now.y == m - 1) {
                System.out.println(now.distance);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int ndistance = now.distance + 1;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (arr[nx][ny] == '0') {
                    if (!now.isBroken) {
                        if (visited[nx][ny][0]) continue;
                        visited[nx][ny][0] = true;
                        queue.offer(new Point(nx, ny, ndistance, false));
                    } else {
                        if (visited[nx][ny][1]) continue;
                        visited[nx][ny][1] = true;
                        queue.offer(new Point(nx, ny, ndistance, true));
                    }
                } else {
                    if (!now.isBroken) {
                        if (visited[nx][ny][1]) continue;
                        visited[nx][ny][1] = true;
                        queue.offer(new Point(nx, ny, ndistance, true));
                    }

                }
            }
        }
        System.out.println(-1);
    }
}


class Point {
    int x;
    int y;
    int distance;
    boolean isBroken;

    public Point(int x, int y, int distance, boolean isBroken) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.isBroken = isBroken;
    }
}
