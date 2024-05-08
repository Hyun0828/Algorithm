import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String[] mbti = reader.readLine().split(" ");
            int distance = 10000000;

            if (n >= 33)
                System.out.println(0);
            else {
                for (int j = 0; j < n; j++)
                    for (int k = 0; k < n && k != j; k++)
                        for (int l = 0; l < n && l != k; l++)
                            distance = Math.min(distance, distance(mbti[j], mbti[k], mbti[l]));
                System.out.println(distance);
            }
        }
    }

    public static int distance(String m1, String m2, String m3) {
        int dis = 0;
        for (int i = 0; i < 4; i++) {
            if (m1.charAt(i) != m2.charAt(i))
                dis++;
        }
        for (int i = 0; i < 4; i++) {
            if (m1.charAt(i) != m3.charAt(i))
                dis++;
        }
        for (int i = 0; i < 4; i++) {
            if (m2.charAt(i) != m3.charAt(i))
                dis++;
        }
        return dis;
    }
}