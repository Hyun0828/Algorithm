import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean isMove;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int days = 0;
        while (true) {
            isMove = false;
            visited = new boolean[N][N];

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visited[y][x]) {
                        bfs(x, y);
                    }
                }
            }

            if (isMove)
                days++;
            else
                break;
        }

        System.out.println(days);
    }

    public static void bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        Set<Point> set = new HashSet<>();
        int sum = 0;

        visited[startY][startX] = true;
        set.add(new Point(startX, startY));
        sum += map[startY][startX];

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[ny][nx])
                    continue;

                int diff = Math.abs(map[y][x] - map[ny][nx]);
                if (diff >= L && diff <= R) {
                    queue.add(new Point(nx, ny));
                    visited[ny][nx] = true;
                    sum += map[ny][nx];
                    set.add(new Point(nx, ny));
                    isMove = true;
                }
            }
        }

        int avg = sum / set.size();
        set.forEach(point -> {
            map[point.y][point.x] = avg;
        });
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}