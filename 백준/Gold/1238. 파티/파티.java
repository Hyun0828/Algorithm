import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static boolean[] visited;
    public static PriorityQueue<Edge> pq;
    public static List<Edge>[] list;
    public static int[] distance;
    public static int[] time;
    public static int N, M, X;
    public static int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        X = Integer.parseInt(input[2]);
        list = new ArrayList[N + 1];
        distance = new int[N + 1];
        time = new int[N + 1];
        pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            input = reader.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            list[from].add(new Edge(to, weight));
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(distance, INF);
            distance[i] = 0;
            visited = new boolean[N + 1];
            visited[i] = true;
            pq.offer(new Edge(i, 0));
            Dijkstra();

            if (i != X)
                time[i] += distance[X];
            else {
                for (int j = 1; j <= N; j++)
                    time[j] += distance[j];
            }
        }

        Arrays.sort(time);
        System.out.println(time[N]);
    }

    public static void Dijkstra() {

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            visited[edge.next] = true;

            for (Edge e : list[edge.next]) {
                if (!visited[e.next]) {
                    if (distance[e.next] > distance[edge.next] + e.weight) {
                        distance[e.next] = distance[edge.next] + e.weight;
                        pq.offer(new Edge(e.next, distance[e.next]));
                    }
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