import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Pair> dice = new ArrayList<>();
    static int M;
    static final int X = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(reader.readLine());
        for (int i = 0; i < M; i++) {
            String[] input = reader.readLine().split(" ");
            dice.add(new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        System.out.println(solve());
    }

    // x = X - 2
    // N^x mod X
    private static long dq(int N, int x) {

        if (x == 1)
            return N % X;
        else {
            long result = dq(N, x / 2);
            if (x % 2 == 1)
                return (result * result % X) * N % X;
            else
                return (result * result % X);
        }
    }

    private static long solve() {

        long sum = 0;
        for (Pair pair : dice) {
            int N = pair.N;
            int S = pair.S;

            long n = dq(N, X - 2);
            sum += S * n % X;
        }

        return sum % X;
    }
}

class Pair {
    int N;
    int S;

    public Pair(int n, int s) {
        N = n;
        S = s;
    }
}
