import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static List<String> list = new ArrayList<>();
    public static List<Integer> temp;
    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        arr = new int[n];
        visited = new boolean[n];

        String[] num = reader.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(num[i]);

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            temp = new ArrayList<>();
            temp.add(arr[i]);
            visited[i] = true;
            backTracking(n, m, arr[i]);
            visited[i] = false;
        }
        print();
    }

    public static void backTracking(int n, int m, int data) {
        if (temp.size() == m) {
            list.add(convert());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                temp.add(arr[i]);
                visited[i] = true;
                backTracking(n, m, arr[i]);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void print() {
        Set<String> uniqueStrings = new LinkedHashSet<>(list);
        for (String s : uniqueStrings) {
            System.out.println(s);
        }
    }

    public static String convert() {
        return temp.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
