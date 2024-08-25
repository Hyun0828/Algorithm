import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static List<Edge>[] edges;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static boolean[] visited;
    static PriorityQueue<Integer> sum = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }
        prim(1);
        System.out.println(solve());

    }

    private static int solve() {
        sum.poll();
        int result = 0;
        for (Integer distance : sum)
            result += distance;
        return result;
    }

    private static void prim(int start) {
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int current = e.to;

            if (visited[current]) continue;
            visited[current] = true;
            sum.add(e.weight);

            for (Edge edge : edges[current]) {
                int next = edge.to;
                if (visited[next])
                    continue;
                pq.add(new Edge(next, edge.weight));
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
