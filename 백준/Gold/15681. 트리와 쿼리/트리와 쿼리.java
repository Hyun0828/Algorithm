import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer>[] edges;
    static Node[] nodes;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int Q = Integer.parseInt(input[2]);

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();
        nodes = new Node[N + 1];
        size = new int[N + 1];

        for (int i = 1; i < N; i++) {
            input = reader.readLine().split(" ");
            int U = Integer.parseInt(input[0]);
            int V = Integer.parseInt(input[1]);

            edges[U].add(V);
            edges[V].add(U);
        }

        init(N);
        makeTree(R, -1);
        countSubTreeNodes(R);

        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(reader.readLine());
            System.out.println(size[U]);
        }
    }

    private static void init(int N) {
        for (int i = 1; i <= N; i++)
            nodes[i] = new Node(i);
    }

    private static void makeTree(int currentNode, int parent) {
        for (int node : edges[currentNode]) {
            if (node != parent) {
                if (!nodes[currentNode].child.contains(nodes[node]))
                    nodes[currentNode].child.add(nodes[node]);
                nodes[node].parent = nodes[currentNode];
                makeTree(node, currentNode);
            }
        }
    }

    private static void countSubTreeNodes(int currentNode) {
        size[currentNode] = 1;
        for (Node child : nodes[currentNode].child) {
            countSubTreeNodes(child.value);
            size[currentNode] += size[child.value];
        }
    }
}

class Node {
    int value;
    Node parent;
    List<Node> child;

    public Node(int value) {
        this.value = value;
        this.parent = null;
        this.child = new ArrayList<>();
    }
}