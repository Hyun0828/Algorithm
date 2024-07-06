import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    public static Queue<Node> queue = new LinkedList<Node>();
    public static Set<Integer> visited = new HashSet<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        queue.offer(new Node(n, 0));

        System.out.println(BFS(k));
    }

    public static int BFS(int k) {
        int result = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (visited.contains(current.value) || current.value < 0 || current.value > 100000)
                continue;

            visited.add(current.value);
            if (current.value == k) {
                result = current.level;
                break;
            }

            if (!visited.contains(current.value * 2))
                queue.offer(new Node(current.value * 2, current.level));
            if (!visited.contains(current.value - 1))
                queue.offer(new Node(current.value - 1, current.level + 1));
            if (!visited.contains(current.value + 1))
                queue.offer(new Node(current.value + 1, current.level + 1));
        }
        return result;
    }
}

class Node {
    public int value;
    public int level;

    public Node(int value, int level) {
        this.value = value;
        this.level = level;
    }
}
