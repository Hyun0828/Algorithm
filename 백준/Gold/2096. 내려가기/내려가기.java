import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[][] max;
    public static int[][] min;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        max = new int[n][3];
        min = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            max[i][0] = Integer.parseInt(input[0]);
            max[i][1] = Integer.parseInt(input[1]);
            max[i][2] = Integer.parseInt(input[2]);
            min[i][0] = Integer.parseInt(input[0]);
            min[i][1] = Integer.parseInt(input[1]);
            min[i][2] = Integer.parseInt(input[2]);
        }

        dp(n);

        int max_value = Math.max(Math.max(max[n - 1][0], max[n - 1][1]), max[n - 1][2]);
        int min_value = Math.min(Math.min(min[n - 1][0], min[n - 1][1]), min[n - 1][2]);
        System.out.println(max_value + " " + min_value);

    }

    public static void dp(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    max[i][j] = max[i][j] + Math.max(max[i - 1][j], max[i - 1][j + 1]);
                    min[i][j] = min[i][j] + Math.min(min[i - 1][j], min[i - 1][j + 1]);
                } else if (j == 1) {
                    max[i][j] = max[i][j] + Math.max(Math.max(max[i - 1][j - 1], max[i - 1][j]), max[i - 1][j + 1]);
                    min[i][j] = min[i][j] + Math.min(Math.min(min[i - 1][j - 1], min[i - 1][j]), min[i - 1][j + 1]);
                } else {
                    max[i][j] = max[i][j] + Math.max(max[i - 1][j], max[i - 1][j - 1]);
                    min[i][j] = min[i][j] + Math.min(min[i - 1][j], min[i - 1][j - 1]);
                }
            }
        }
    }
}
