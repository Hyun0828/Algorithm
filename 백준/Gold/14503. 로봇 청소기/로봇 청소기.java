import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = reader.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int d = Integer.parseInt(input[2]);

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = reader.readLine().split(" ");
            arr[i] = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(clean(arr, N, M, r, c, d));
    }

    public static int clean(int[][] arr, int N, int M, int r, int c, int d) {

        int y = r;
        int x = c;
        int count = 0;

        while (true) {
            // 1. 현재 칸이 청소되지 않았다면 청소한다.
            if (arr[y][x] == 0) {
                arr[y][x] = 2;
                count++;
            }

            // 2. 주변 4칸에 청소되지 않은 빈 칸이 없는 경우
            if (!existNoCleanArea(arr, N, M, y, x)) {
                // 2-1. 한 칸 후진할 수 있다면 후진하고 1번으로 돌아간다.
                if (canBack(arr, N, M, y, x, d)) {
                    if (d == 0) {
                        y++;
                    } else if (d == 1) {
                        x--;
                    } else if (d == 2) {
                        y--;
                    } else if (d == 3) {
                        x++;
                    }
                }
                // 2-2. 벽이라 후진할 수 없다면 작동을 멈춘다.
                else {
                    break;
                }
            }
            // 3. 주변 4칸에 청소되지 않은 빈 칸이 있는 경우
            else {
                // 3-1. 반시계 방향으로 90도 회전한다.
                if (d == 0)
                    d = 3;
                else
                    d--;

                // 3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                if (d == 0) {
                    if (y - 1 >= 0 && arr[y - 1][x] == 0)
                        y -= 1;
                } else if (d == 1) {
                    if (x + 1 < M && arr[y][x + 1] == 0)
                        x += 1;
                } else if (d == 2) {
                    if (y + 1 < N && arr[y + 1][x] == 0)
                        y += 1;
                } else if (d == 3) {
                    if (x - 1 >= 0 && arr[y][x - 1] == 0)
                        x -= 1;
                }

                // 3-3. 1번으로 돌아간다.
            }
        }

        return count;
    }

    public static boolean existNoCleanArea(int[][] arr, int N, int M, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int ny = r + dy[i];
            int nx = c + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                continue;

            if (arr[ny][nx] == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean canBack(int[][] arr, int N, int M, int r, int c, int d) {
        if (d == 0) {
            return r + 1 < N && arr[r + 1][c] != 1;
        } else if (d == 1) {
            return c - 1 >= 0 && arr[r][c - 1] != 1;
        } else if (d == 2) {
            return r - 1 >= 0 && arr[r - 1][c] != 1;
        } else if (d == 3) {
            return c + 1 < M && arr[r][c + 1] != 1;
        }
        return false;
    }
}