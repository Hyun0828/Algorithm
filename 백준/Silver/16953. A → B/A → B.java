import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    public static Queue<Node> queue = new LinkedList<>();
    public static Set<Long> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);

        queue.offer(new Node(a, 1));
        set.add(a);
        int cnt = BFS(b);
        if (cnt >= 1)
            System.out.println(cnt + 1);
        else
            System.out.println("-1");
    }

    public static int BFS(long b) {
        while (!queue.isEmpty()) {
            Node cnode = queue.poll();
            long current = cnode.value;
            int level = cnode.level;

            if (current * 2 == b || current * 10 + 1 == b)
                return level;

            if(current > b)
                continue;

            if (!set.contains(current * 2)) {
                queue.offer(new Node(current * 2, level + 1));
                set.add(current * 2);
            }
            if (!set.contains(current * 10 + 1)) {
                queue.offer(new Node(current * 10 + 1, level + 1));
                set.add(current * 10 + 1);
            }
        }
        return -1;
    }
}

class Node {
    long value;
    int level;

    public Node(long value, int level) {
        this.value = value;
        this.level = level;
    }
}
