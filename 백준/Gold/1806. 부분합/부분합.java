import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int result = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        arr = new int[N + 1];
        input = reader.readLine().split(" ");
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);

        partial_Sum(N, S);
        System.out.println(result == 1000000 ? 0 : result);
    }
    private static void partial_Sum(int N, int S) {

        int left = 0;
        int right = 0;
        int sum = 0;
        while (left <= right && right <= N) {
            if (sum < S)
                sum += arr[right++];
            else {
                result = Math.min(result, right - left);
                sum -= arr[left++];
            }
        }
    }
}