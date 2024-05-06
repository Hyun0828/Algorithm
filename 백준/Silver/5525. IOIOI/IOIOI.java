import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        char[] S = reader.readLine().toCharArray();
        char[] p = new char[2 * N + 1];
        for (int i = 0; i < p.length; i++) {
            if (i % 2 == 0)
                p[i] = 'I';
            else
                p[i] = 'O';
        }

        int[] pi = new int[2 * N + 1];
        getPI(p, pi);
        System.out.println(KMP(S, p, pi));
    }

    public static void getPI(char[] p, int[] pi) {
        int j = 0;
        for (int i = 1; i < p.length; i++) {
            while (j > 0 && p[i] != p[j])
                j = pi[j - 1];
            if (p[i] == p[j])
                pi[i] = ++j;
        }
    }

    public static int KMP(char[] S, char[] p, int[] pi) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < S.length; i++) {
            while (j > 0 && S[i] != p[j])
                j = pi[j - 1];
            if (S[i] == p[j]) {
                if (j == p.length - 1) {
                    count++;
                    j = pi[j];
                } else
                    j++;
            }
        }
        return count;
    }
}