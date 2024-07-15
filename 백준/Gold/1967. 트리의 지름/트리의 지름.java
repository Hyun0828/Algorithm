import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static boolean[] visited;
    public static List<Edge>[] list;
    public static List<Integer> leaf_nodes;
    public static int N;
    public static int radius;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        leaf_nodes = new ArrayList<>();
        radius = 0;

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            String[] input = reader.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            list[from].add(new Edge(to, weight));
            list[to].add(new Edge(from, weight));
        }

        // 리프 노드 선별하기
        for (int i = 1; i <= N; i++)
            if (list[i].size() == 1)
                leaf_nodes.add(i);

        for (int node : leaf_nodes) {
            visited[node] = true;
            DFS(list[node].get(0), list[node].get(0).weight);
            Arrays.fill(visited, false);
        }

        System.out.println(radius);
    }

    public static void DFS(Edge current, int temp) {

        visited[current.next] = true;

        if (list[current.next].size() == 1) {
            radius = Math.max(radius, temp);
            return;
        }

        for (int i = 0; i < list[current.next].size(); i++) {
            Edge next = list[current.next].get(i);
            if (!visited[next.next])
                DFS(next, temp + next.weight);
        }
    }
}

class Edge {

    public int next;
    public int weight;

    public Edge(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }
}