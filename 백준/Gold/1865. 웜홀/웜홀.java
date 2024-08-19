import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<Edge>[] edges;
    static int[] distance;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            edges = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++)
                edges[j] = new ArrayList<>();

            distance = new int[n + 1];


            for (int j = 1; j <= m; j++) {
                input = reader.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                int weight = Integer.parseInt(input[2]);

                edges[start].add(new Edge(end, weight));
                edges[end].add(new Edge(start, weight));
            }

            for (int j = 1; j <= w; j++) {
                input = reader.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                int weight = Integer.parseInt(input[2]);

                edges[start].add(new Edge(end, weight * -1));
            }

            if (!bellman_Ford(1, n))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean bellman_Ford(int start, int n) {

        Arrays.fill(distance, INF);
        distance[start] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (Edge edge : edges[j]) {
                    int current = j;
                    int next = edge.to;
                    int weight = edge.weight;

                    if (distance[next] > distance[current] + weight) {
                        distance[next] = distance[current] + weight;
                        if (i == n)
                            return false;
                    }
                }
            }
        }
        return true;
    }
}

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}