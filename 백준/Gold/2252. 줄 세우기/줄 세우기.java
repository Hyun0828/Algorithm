import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] inDegree;
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        inDegree = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            input = reader.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            inDegree[B]++;
            graph[A].add(B);
        }

        topologicalSort();
    }

    public static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && inDegree[i] == 0) {
                queue.add(i);
                visited[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            List<Integer> neighbours = graph[node];

            neighbours.forEach(neighbour -> {
                inDegree[neighbour]--;
            });

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && inDegree[i] == 0) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}