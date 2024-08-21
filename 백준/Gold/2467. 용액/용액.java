import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int sum = 2000000002;
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        arr = new int[n];
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(input[i]);

        binarySearch(0, n);
        System.out.println(x + " " + y);
    }

    private static void binarySearch(int start, int end) {

        int s = start;
        int e = end - 1;

        while (s < e) {
            int curr = arr[s] + arr[e];
            if (sum > Math.abs(curr)) {
                sum = Math.abs(curr);
                x = arr[s];
                y = arr[e];
            }

            if (curr > 0)
                e--;
            else if (curr < 0)
                s++;
            else
                return;
        }
    }
}
