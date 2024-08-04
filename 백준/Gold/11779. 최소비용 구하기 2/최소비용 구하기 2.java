import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static List<Edge>[] edges;
    static long[] distance;
    static boolean[] visited;
    static int[] path;
    static List<Integer> answer = new ArrayList<>();

    static int start;
    static int end;
    static int n;
    static int m;
    static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();
        distance = new long[n + 1];
        visited = new boolean[n + 1];
        path = new int[n + 1];

        Arrays.fill(distance, INF);

        for (int i = 0; i < m; i++) {
            String[] input = reader.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            edges[from].add(new Edge(to, weight));
        }

        String[] input = reader.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);

        Dijkstra();
        findPath();

        System.out.println(distance[end]);
        System.out.println(answer.size());
        for (int i = answer.size() - 1; i >= 0; i--)
            System.out.print(answer.get(i) + " ");
    }

    private static void Dijkstra() {

        pq.offer(new Edge(start, 0));
        distance[start] = 0;
        path[start] = start;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int current = edge.to;
            if (visited[current])
                continue;
            visited[current] = true;

            for (Edge e : edges[current]) {
                int next = e.to;
                if (distance[next] > distance[current] + e.weight) {
                    distance[next] = distance[current] + e.weight;
                    pq.offer(new Edge(next, distance[next]));
                    path[next] = current;
                }
            }
        }
    }

    private static void findPath() {

        int idx = end;
        while (idx != start) {
            answer.add(idx);
            idx = path[idx];
        }
        answer.add(start);
    }
}

class Edge implements Comparable<Edge> {
    int to;
    long weight;

    public Edge(int to, long weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.weight, o.weight);
    }
}
