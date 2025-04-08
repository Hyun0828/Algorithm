import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            int op = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if (op == 0) {
                union(a, b);
            } else if (op == 1) {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) {
            return;
        }

        if (rank[parentA] > rank[parentB]) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
            if (rank[parentA] == rank[parentB]) {
                rank[parentB]++;
            }
        }
    }
}