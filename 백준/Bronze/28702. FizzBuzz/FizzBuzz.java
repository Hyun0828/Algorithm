import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int num = 0;
        int idx = 0;

        if (isInteger(s1)) {
            num = Integer.parseInt(s1);
            idx = 1;
        }
        if (isInteger(s2)) {
            num = Integer.parseInt(s2);
            idx = 2;
        }
        if (isInteger(s3)) {
            num = Integer.parseInt(s3);
            idx = 3;
        }

        if ((num + (4 - idx)) % 3 == 0 && (num + (4 - idx)) % 5 == 0)
            System.out.println("FizzBuzz");
        else if ((num + (4 - idx)) % 3 == 0)
            System.out.println("Fizz");
        else if ((num + (4 - idx)) % 5 == 0)
            System.out.println("Buzz");
        else
            System.out.println(num + (4 - idx));
    }

    public static boolean isInteger(String s) {
        if (s == null || s.isEmpty())
            return false;

        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}