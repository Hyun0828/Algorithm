import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Point> home = new ArrayList<>();
    public static List<Point> chome = new ArrayList<>();
    public static boolean[] visited;
    public static int min = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(input[j]) == 1)
                    home.add(new Point(i + 1, j + 1));
                else if (Integer.parseInt(input[j]) == 2)
                    chome.add(new Point(i + 1, j + 1));
            }
        }
        visited = new boolean[chome.size()];
        backTracking(m, 0, 0);
        System.out.println(min);
    }

    public static void backTracking(int m, int cnt, int idx) {
        if (cnt == m) {
            min = Math.min(min, calculate());
            return;
        }

        for (int i = idx; i < chome.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(m, cnt + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static int calculate() {
        int result = 0;
        for (int i = 0; i < home.size(); i++) {
            int x = 1000000;
            for (int j = 0; j < chome.size(); j++)
                if(visited[j])
                    x = Math.min(Math.abs(home.get(i).x - chome.get(j).x) + Math.abs(home.get(i).y - chome.get(j).y), x);
            result += x;
        }
        return result;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

