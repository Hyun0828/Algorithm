import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {

    private static int[][] D;
    private static int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        D = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                D[i][j] = INF;

        for (int i = 1; i <= N; i++) {
            String[] n = reader.readLine().split(" ");
            for (int j = 1; j <= N; j++)
                if (Objects.equals(n[j - 1], "1"))
                    D[i][j] = Integer.parseInt(n[j - 1]);
        }

        Floyd(N);


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (D[i][j] == INF)
                    System.out.print('0' + " ");
                else
                    System.out.print('1' + " ");
            }
            System.out.println();
        }
    }

    public static void Floyd(int N) {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++)
                    D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
            }
        }
    }
}