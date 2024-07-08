import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[][] arr;
    public static Type[][] dp;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n + 1][n + 1];
        dp = new Type[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i + 1][j + 1] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = new Type(0);
        dp[1][2].type[0] = 1; // 가로

        DP();
        System.out.println(dp[n][n].type[0] + dp[n][n].type[1] + dp[n][n].type[2]);
    }

    public static void DP() {
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                if (arr[i][j] == 1)
                    continue;
                int t1 = dp[i][j].type[0]; // 가로
                int t2 = dp[i][j].type[1]; // 세로
                int t3 = dp[i][j].type[2]; // 대각선
                if (t1 > 0) {
                    horizontal(i, j, 0);
                    diagonal(i, j, 0);
                }
                if (t2 > 0) {
                    vertical(i, j, 1);
                    diagonal(i, j, 1);
                }
                if (t3 > 0) {
                    horizontal(i, j, 2);
                    vertical(i, j, 2);
                    diagonal(i, j, 2);
                }
            }
        }
    }

    public static void horizontal(int i, int j, int value) {
        if (j < n && arr[i][j + 1] != 1) {
            if (value == 0)
                dp[i][j + 1].type[0] += dp[i][j].type[0];
            else if (value == 2)
                dp[i][j + 1].type[0] += dp[i][j].type[2];
        }
    }

    public static void vertical(int i, int j, int value) {
        if (i < n && arr[i + 1][j] != 1) {
            if (value == 1)
                dp[i + 1][j].type[1] += dp[i][j].type[1];
            else if (value == 2)
                dp[i + 1][j].type[1] += dp[i][j].type[2];
        }
    }

    public static void diagonal(int i, int j, int value) {
        if (i < n && j < n && arr[i][j + 1] != 1 && arr[i + 1][j] != 1 && arr[i + 1][j + 1] != 1) {
            if (value == 0)
                dp[i + 1][j + 1].type[2] += dp[i][j].type[0];
            else if (value == 1)
                dp[i + 1][j + 1].type[2] += dp[i][j].type[1];
            else if (value == 2)
                dp[i + 1][j + 1].type[2] += dp[i][j].type[2];
        }
    }
}

class Type {
    int value;
    int[] type;

    public Type(int value) {
        this.value = value;
        type = new int[3];
    }
}

