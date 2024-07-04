import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static List<Edge>[] list;
    public static long[] distance;
    public static boolean[] visited;
    public static PriorityQueue<Edge> pq;
    public static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        list = new ArrayList[n + 1];
        distance = new long[n + 1];
        visited = new boolean[n + 1];
        pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] input = reader.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            list[from].add(new Edge(to, weight));
        }

        String[] input = reader.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        Arrays.fill(distance, INF);
        distance[start] = 0;
        pq.add(new Edge(start, 0));

        Dijkstra(n);

        System.out.println(distance[end]);
    }

    public static void Dijkstra(int n) {

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (visited[edge.next])
                continue;

            int current = edge.next;
            visited[current] = true;

            for (Edge e : list[current]) {
                if (distance[e.next] > distance[current] + e.weight) {
                    distance[e.next] = distance[current] + e.weight;
                    pq.offer(new Edge(e.next, distance[e.next]));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    public int next;
    public long weight;

    public Edge(int next, long weight) {
        this.next = next;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.weight, o.weight);
    }
}
