import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Set<Integer> visited;
    static Set<Integer> numberSet;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        visited = new HashSet<>();
        numberSet = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            numberSet.add(i);
        }
        if (M > 0) {
            int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < arr.length; i++) {
                numberSet.remove(arr[i]);
            }
        }

        int res = Math.abs(100 - N);
        if (N == 100)
            System.out.println(0);
        else {
            for (int i = 0; i <= 999999; i++) {
                if (!check(i)) {
                    continue;
                }
                res = Math.min(res, Math.abs(N - i) + String.valueOf(i).length());
            }
            System.out.println(res);
        }
    }

    public static boolean check(int n) {
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            if (!numberSet.contains(s.charAt(i) - '0')) {
                return false;
            }
        }
        return true;
    }
}