import java.io.*;

public class Main {

    static Color[] color;
    static int N;
    static final int INF = 1000000000;
    static int answer = INF;
    
    static Color[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        color = new Color[N + 1];
        dp = new Color[N + 1];

        for (int i = 0; i < N; i++) {
            dp[i + 1] = new Color(0, 0, 0);

            String[] input = reader.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int g = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            color[i + 1] = new Color(r, g, b);
        }

        solve();
        System.out.println(answer);
    }

    private static void solve() {
        dp(1);
        answer = Math.min(Math.min(dp[N].g, dp[N].b), answer);
        dp(2);
        answer = Math.min(Math.min(dp[N].r, dp[N].b), answer);
        dp(3);
        answer = Math.min(Math.min(dp[N].r, dp[N].g), answer);
    }

    private static void dp(int choice) {
        for (int i = 1; i <= N; i++)
            dp[i].reset();

        if (choice == 1) {
            dp[1].r = color[1].r;
            dp[1].g = INF;
            dp[1].b = INF;
        } else if (choice == 2) {
            dp[1].r = INF;
            dp[1].g = color[1].g;
            dp[1].b = INF;
        } else {
            dp[1].r = INF;
            dp[1].g = INF;
            dp[1].b = color[1].b;
        }

        for (int i = 2; i <= N; i++) {
            dp[i].r = Math.min(dp[i - 1].g, dp[i - 1].b) + color[i].r;
            dp[i].g = Math.min(dp[i - 1].r, dp[i - 1].b) + color[i].g;
            dp[i].b = Math.min(dp[i - 1].r, dp[i - 1].g) + color[i].b;
        }
    }
}

class Color {
    int r;
    int g;
    int b;

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void reset() {
        this.r = 0;
        this.g = 0;
        this.b = 0;
    }
}