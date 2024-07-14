import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static PriorityQueue<Edge> pq;
    public static boolean[] visited;
    public static int[] distance;
    public static List<Edge>[] list;
    public static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            input = reader.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            list[from].add(new Edge(to, weight));
            list[to].add(new Edge(from, weight));
        }

        input = reader.readLine().split(" ");
        int v1 = Integer.parseInt(input[0]);
        int v2 = Integer.parseInt(input[1]);

        Dijkstra(v1);
        int distance_1_v1 = distance[1];
        int distance_v1_v2 = distance[v2];
        int distance_v1_N = distance[N];
        Dijkstra(v2);
        int distance_1_v2 = distance[1];
        int distance_v2_v1 = distance[v1];
        int distance_v2_N = distance[N];

        int distance_1 = distance_1_v1 + distance_v1_v2 + distance_v2_N;
        int distance_2 = distance_1_v2 + distance_v2_v1 + distance_v1_N;

        boolean condition_1 = (distance_1_v1 >= INF || distance_v1_v2 >= INF || distance_v1_N >= INF);
        boolean condition_2 = (distance_2 >= INF || distance_v2_v1 >= INF || distance_v2_N >= INF);
        if (condition_1 && condition_2)
            System.out.println("-1");
        else if (condition_1)
            System.out.println(distance_2);
        else if (condition_2)
            System.out.println(distance_1);
        else
            System.out.println(Math.min(distance_1, distance_2));

    }

    public static void Dijkstra(int start) {

        pq = new PriorityQueue<>();
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);

        distance[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (visited[e.next])
                continue;

            visited[e.next] = true;
            for (Edge edge : list[e.next]) {
                if (distance[edge.next] > distance[e.next] + edge.weight) {
                    distance[edge.next] = distance[e.next] + edge.weight;
                    pq.offer(new Edge(edge.next, distance[edge.next]));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {

    public int next;
    public int weight;

    public Edge(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}