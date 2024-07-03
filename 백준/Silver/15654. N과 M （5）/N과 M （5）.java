import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<Integer> temp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] arr = new int[n];

        String[] num = reader.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(num[i]);

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            temp = new ArrayList<>();
            temp.add(arr[i]);
            backTracking(n, m, arr, arr[i]);
        }
    }

    public static void backTracking(int n, int m, int[] arr, int data) {
        if (temp.size() == m) {
            print();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!temp.contains(arr[i])) {
                temp.add(arr[i]);
                backTracking(n, m, arr, arr[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void print() {
        for (int data : temp)
            System.out.print(data + " ");
        System.out.println();
    }
}
