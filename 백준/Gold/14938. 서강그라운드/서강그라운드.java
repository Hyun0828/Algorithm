import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] items;
    static int[][] distance;

    static int n;
    static int m;
    static int INF = 99999999;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);

        items = new int[n + 1];
        distance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            Arrays.fill(distance[i], INF);
        for (int i = 1; i <= n; i++)
            distance[i][i] = 0;


        input = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            items[i] = Integer.parseInt(input[i - 1]);

        for (int i = 0; i < r; i++) {
            input = reader.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            distance[from][to] = weight;
            distance[to][from] = weight;
        }

        Floyd();
        System.out.println(get_items());
    }

    private static void Floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }

    private static int get_items() {
        int max_items = 0;

        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] <= m)
                    temp += items[j];
            }
            max_items = Math.max(max_items, temp);
        }

        return max_items;
    }
}
