import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Edge>[] edges;
    static boolean[] visited;
    static int v;
    static int max_distance;
    static int node;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(reader.readLine());
        edges = new ArrayList[v + 1];
        visited = new boolean[v + 1];

        for (int i = 1; i <= v; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            String[] input = reader.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            for (int j = 1; j < input.length - 1; j += 2) {
                int to = Integer.parseInt(input[j]);
                int weight = Integer.parseInt(input[j + 1]);
                edges[from].add(new Edge(to, weight));
                edges[to].add(new Edge(from, weight));
            }
        }

        DFS(1, 0);

        visited = new boolean[v + 1];
        DFS(node, 0);

        System.out.println(max_distance);
    }

    private static void DFS(int current, int distance) {

        if (max_distance < distance) {
            max_distance = distance;
            node = current;
        }
        visited[current] = true;

        for (Edge next : edges[current]) {
            if (!visited[next.next]) {
                visited[next.next] = true;
                DFS(next.next, distance + next.weight);
            }
        }
    }
}

class Edge {
    int next;
    int weight;

    public Edge(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }
}
