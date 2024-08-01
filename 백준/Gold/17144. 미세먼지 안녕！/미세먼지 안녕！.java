import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static Queue<Point> dusts;
    public static int[][] arr;
    public static int R;
    public static int C;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        int t = Integer.parseInt(input[2]);
        int x1 = 0;
        int x2 = 0;

        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                if (arr[i][j] == -1)
                    x2 = i;
            }
        }
        x1 = x2 - 1;

        for (int k = 0; k < t; k++) {
            check();
            spread();
            cleanUp(x1);
            cleanDown(x2);
        }

        int sum = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                sum += arr[i][j];

        System.out.println(sum + 2);
    }

    private static void check() {
        dusts = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == -1 || arr[i][j] == 0)
                    continue;
                dusts.add(new Point(i, j, arr[i][j]));
            }
        }
    }

    public static void spread() {

        while (!dusts.isEmpty()) {
            Point p = dusts.poll();

            if (p.w < 5)
                continue;

            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (arr[nx][ny] != -1) {
                        arr[nx][ny] += p.w / 5;
                        cnt++;
                    }
                }
            }
            arr[p.x][p.y] -= p.w / 5 * cnt;
        }
    }

    public static void cleanUp(int x) {

        // 왼쪽
        for (int i = x - 1; i > 0; i--)
            if (arr[i][0] != -1)
                arr[i][0] = arr[i - 1][0];

        // 위
        for (int i = 0; i < C - 1; i++)
            if (arr[0][i] != -1)
                arr[0][i] = arr[0][i + 1];

        // 오른쪽
        for (int i = 0; i < x; i++)
            if (arr[i][C - 1] != -1)
                arr[i][C - 1] = arr[i + 1][C - 1];

        // 아래
        for (int i = C - 1; i > 1; i--)
            if (arr[x][i] != -1)
                arr[x][i] = arr[x][i - 1];

        arr[x][1] = 0;
    }

    public static void cleanDown(int x) {

        // 왼쪽
        for (int i = x + 1; i < R - 1; i++)
            if (arr[i][0] != -1)
                arr[i][0] = arr[i + 1][0];

        // 아래
        for (int i = 0; i < C - 1; i++)
            if (arr[R - 1][i] != -1)
                arr[R - 1][i] = arr[R - 1][i + 1];

        // 오른쪽
        for (int i = R - 1; i > x; i--)
            if (arr[i][C - 1] != -1)
                arr[i][C - 1] = arr[i - 1][C - 1];

        // 위
        for (int i = C - 1; i > 1; i--)
            if (arr[x][i] != -1)
                arr[x][i] = arr[x][i - 1];

        arr[x][1] = 0;
    }
}

class Point {
    int x;
    int y;
    int w;

    public Point(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
}