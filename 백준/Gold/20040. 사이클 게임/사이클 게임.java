import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] parent;
    static int[] rank;
    static int n;
    static int m;
    static int stage = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);

            // cycle이 생겼다!
            if (find_Root(from) == find_Root(to)) {
                stage = i + 1;
                break;
            }

            union_Root(from, to);
        }

        if (stage > 0)
            System.out.println(stage);
        else
            System.out.println("0");
    }

    private static int find_Root(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find_Root(parent[x]);
    }

    private static void union_Root(int x, int y) {
        int parent_x = find_Root(x);
        int parent_y = find_Root(y);

        if (parent_x != parent_y) {
            if (rank[parent_x] < rank[parent_y])
                parent[parent_x] = parent_y;
            else {
                parent[parent_y] = parent_x;
                if (rank[parent_x] == rank[parent_y])
                    rank[parent_x]++;
            }
        }
    }
}