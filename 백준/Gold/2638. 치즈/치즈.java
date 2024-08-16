import java.io.*;
import java.util.*;

public class Main {

    static Queue<Point> queue;
    static boolean[][] visited;
    static Air[][] arr;
    static List<Point> cheeses = new ArrayList<>();
    static int n;
    static int m;
    static int result = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new Air[n][m];

        for (int i = 0; i < n; i++) {
            input = reader.readLine().split(" ");
            arr[i] = new Air[m];
            for (int j = 0; j < m; j++) {
                if (Integer.parseInt(input[j]) == 1) {
                    arr[i][j] = new Air(false, false);
                    cheeses.add(new Point(i, j));
                } else
                    arr[i][j] = new Air(true, false);
            }
        }

        while (!cheeses.isEmpty()) {
            divide();
            melt();
        }
        System.out.println(result);
    }

    private static void divide() {

        visited = new boolean[n][m];
        queue = new LinkedList<>();

        queue.offer(new Point(0, 0));
        arr[0][0].isOutAir = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int x = now.x;
            int y = now.y;

            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (arr[nx][ny].isAir && !visited[nx][ny]) {
                    arr[nx][ny].isOutAir = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    private static void melt() {
        Iterator<Point> iterator = cheeses.iterator();

        while (iterator.hasNext()) {
            Point cheese = iterator.next();
            int x = cheese.x;
            int y = cheese.y;

            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (arr[nx][ny].isAir && arr[nx][ny].isOutAir) {
                    cnt++;
                }
            }

            if (cnt >= 2) {
                arr[x][y].isAir = true;
                arr[x][y].isOutAir = false;
                iterator.remove(); // 안전하게 요소를 제거
            }
        }
        result++;
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

class Air {
    boolean isAir;
    boolean isOutAir;

    public Air(boolean isAir, boolean isOutAir) {
        this.isAir = isAir;
        this.isOutAir = isOutAir;
    }
}
