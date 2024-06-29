import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] num = reader.readLine().split(" ");

        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(num[i]);

        int res = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = i + 1; j <= 9; j++) {
                res = Math.max(res, func(n, i, j));
            }
        }
        System.out.println(res);
    }

    public static int func(int n, int n1, int n2) {
        boolean[] p = new boolean[n];
        for (int i = 0; i < n; i++)
            p[i] = (arr[i] == n1 || arr[i] == n2);

        int ret = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (p[i])
                cnt++;
            else
                cnt = 0;

            ret = Math.max(ret, cnt);
        }
        return ret;
    }


}