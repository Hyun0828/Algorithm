import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int K = Integer.parseInt(input[0]);

        for (int j = 0; j < K; j++) {
            input = reader.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);

            List<Integer>[] graph = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                input = reader.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);

                graph[u].add(v);
                graph[v].add(u);
            }

            if (check(graph, V)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean check(List<Integer>[] graph, int V) {
        int[] graphColor = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            if (graphColor[i] == 0)
                graphColor[i] = 1;

            while (!queue.isEmpty()) {
                int s = queue.poll();

                List<Integer> neighbours = graph[s];
                for (Integer neighbour : neighbours) {
                    if (graphColor[neighbour] == 0) {
                        graphColor[neighbour] = graphColor[s] * -1;
                        queue.add(neighbour);
                    } else if (graphColor[neighbour] == graphColor[s]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}