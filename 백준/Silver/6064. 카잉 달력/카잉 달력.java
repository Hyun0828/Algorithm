import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = reader.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);

            int result = 0;
            int k = x;
            while (k <= m * n) {
                if ((k - x) % m == 0 && (k - y) % n == 0) {
                    result = k;
                    break;
                }
                k += m;
            }

            if (result != 0)
                System.out.println(result);
            else
                System.out.println("-1");
        }
    }
}