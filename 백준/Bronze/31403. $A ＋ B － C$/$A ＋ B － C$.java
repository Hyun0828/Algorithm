import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int temp = b;


        System.out.println(a + b - c);
        while (temp > 0) {
            temp /= 10;
            a *= 10;
        }
        System.out.println(a + b - c);
    }
}