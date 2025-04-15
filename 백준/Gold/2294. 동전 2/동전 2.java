import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(reader.readLine());
        }

        System.out.println(bfs(coin, k));
    }

    public static int bfs(int[] coin, int k) {
        Queue<Pair> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(new Pair(0, 0));
        visited.add(0);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int value = pair.value;
            int count = pair.count;

            if (value == k) {
                return count;
            }

            for (int i = 0; i < coin.length; i++) {
                int newValue = value + coin[i];
                if (visited.contains(newValue) || newValue > k) {
                    continue;
                }
                queue.add(new Pair(newValue, count + 1));
                visited.add(newValue);
            }
        }

        return -1;
    }

    static class Pair {
        int value;
        int count;

        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}