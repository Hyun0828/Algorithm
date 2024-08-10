import java.io.*;

public class Main {

    static char[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        arr = new char[n][2 * n - 1];

        star(n, 0, n - 1);
        print(writer);
        writer.flush();
    }

    private static void star(int n, int row, int col) {

        if (n == 3) {
            basic_star(row, col);
            return;
        }

        star(n / 2, row, col);
        star(n / 2, row + n / 2, col - n / 2);
        star(n / 2, row + n / 2, col + n / 2);
    }

    private static void basic_star(int row, int col) {

        arr[row][col] = '*';

        for (int i = -1; i <= 1; i += 2)
            arr[row + 1][col + i] = '*';

        for (int i = -2; i <= 2; i++)
            arr[row + 2][col + i] = '*';
    }

    private static void print(BufferedWriter writer) throws IOException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if (arr[i][j] == '*')
                    writer.write(arr[i][j]);
                else
                    writer.write(' ');
            }
            writer.write("\n");
        }
    }
}
