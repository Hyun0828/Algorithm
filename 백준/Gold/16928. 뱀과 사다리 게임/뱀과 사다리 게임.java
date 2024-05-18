import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[] map = new int[101];
    private static int[] visited = new int[101];
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] num = reader.readLine().split(" ");
        int n = Integer.parseInt(num[0]);
        int m = Integer.parseInt(num[1]);

        for (int i = 0; i < n + m; i++) {
            String[] l = reader.readLine().split(" ");
            map[Integer.parseInt(l[0])] = Integer.parseInt(l[1]);
        }
        for (int i = 2; i < 101; i++)
            visited[i] = 9999;

        queue.offer(1);
        BFS(n, m);
        System.out.println(visited[100]);
    }

    public static void BFS(int n, int m) {
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = current + i;
                if (next > 100)      // 100을 넘으면 고려 X
                    break;
                if (map[next] > 0)     // 뱀이나 사다리를 타면
                    next = map[next];

                if (visited[next] > visited[current] + 1) {
                    visited[next] = visited[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}