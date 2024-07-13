import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int[] parent;
    public static int[] rank;
    public static List<Integer> know = new ArrayList<>();
    public static List<List<Integer>> party = new ArrayList<List<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = reader.readLine().split(" ");
        if (Integer.parseInt(input[0]) > 0)
            for (int i = 0; i < Integer.parseInt(input[0]); i++)
                know.add(Integer.parseInt(input[i + 1]));

        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            List<Integer> currentParty = new ArrayList<>();
            for (int j = 0; j < num; j++)
                currentParty.add(Integer.parseInt(input[j + 1]));
            party.add(currentParty);
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
        rank = new int[n + 1];

        // 모든 파티의 구성원들끼리 union -> 같은 집합으로 만든다.
        for (int i = 0; i < m; i++)
            for (int j = 0; j < party.get(i).size() - 1; j++)
                union(party.get(i).get(j), party.get(i).get(j + 1));

        if (know.isEmpty())
            System.out.println(m);
        else {
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                int root_party = find(party.get(i).get(0));
                boolean flag = true;
                for (int know_person : know) {
                    if (root_party == find(know_person)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    cnt++;
            }
            System.out.println(cnt);
        }
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int u, int v) {
        int parent_u = find(u);
        int parent_v = find(v);

        if (parent_u != parent_v) {
            if (rank[parent_u] < rank[parent_v])
                parent[parent_u] = parent_v;
            else {
                parent[parent_v] = parent_u;
                if (rank[parent_u] == rank[parent_v])
                    rank[parent_u]++;
            }
        }
    }
}