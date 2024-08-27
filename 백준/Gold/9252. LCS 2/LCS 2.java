import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] a;
    static char[] b;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        a = reader.readLine().toCharArray();
        b = reader.readLine().toCharArray();
        dp = new int[a.length + 1][b.length + 1];

        find_Length();
        find_String();

        System.out.println(dp[a.length][b.length]);
        if (dp[a.length][b.length] != 0)
            System.out.println(sb.reverse().toString());

    }

    private static void find_Length() {
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    private static void find_String() {
        int i = a.length;
        int j = b.length;

        while (dp[i][j] != 0) {
            if (dp[i][j] == dp[i - 1][j])
                i--;
            else if (dp[i][j] == dp[i][j - 1])
                j--;
            else {
                sb.append(a[i - 1]);
                i--;
                j--;
            }
        }
    }
}
