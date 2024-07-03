import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] dp = new int[2][n];
            for (int j = 0; j < 2; j++) {
                dp[j] = new int[n];
                String[] num = reader.readLine().split(" ");
                for (int k = 0; k < n; k++)
                    dp[j][k] = Integer.parseInt(num[k]);
            }

            DP(dp, n);
            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }

    public static void DP(int[][] dp, int n) {
        if (n == 1)
            return;
        
        dp[0][1] += dp[1][0];
        dp[1][1] += dp[0][0];

        for (int i = 2; i < n; i++) {
            dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
            dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
        }
    }
}
