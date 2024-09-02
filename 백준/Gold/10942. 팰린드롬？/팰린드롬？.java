import java.io.*;

public class Main {

    static boolean[][] dp;
    static int[] num;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        num = new int[N + 1];
        dp = new boolean[N + 1][N + 1];
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < N; i++)
            num[i + 1] = Integer.parseInt(input[i]);
        M = Integer.parseInt(reader.readLine());

        dp();

        for (int i = 0; i < M; i++) {
            input = reader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            if (isPalindrome(start, end))
                writer.write("1");
            else
                writer.write("0");
            writer.write("\n");
        }
        writer.flush();
    }

    private static boolean isPalindrome(int start, int end) {
        return dp[start][end];
    }

    private static void dp() {
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                int x = j;
                int y = i + j;

                if (x == y)
                    dp[x][y] = true;
                else if (y == x + 1) {
                    if (num[x] == num[y])
                        dp[x][y] = true;
                } else if (y >= x + 2) {
                    if (dp[x + 1][y - 1] && num[x] == num[y])
                        dp[x][y] = true;
                }
            }
        }
    }
}