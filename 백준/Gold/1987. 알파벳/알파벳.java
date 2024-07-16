import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static char[][] arr;
    public static Set<Character> visited = new HashSet<>();
    public static int r;
    public static int c;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        arr = new char[r][c];

        for (int i = 0; i < r; i++)
            arr[i] = reader.readLine().toCharArray();

        visited.add(arr[0][0]);
        DFS(0, 0, 1);
        System.out.println(result);
    }

    public static void DFS(int x, int y, int temp) {

        boolean flag = true; // 갈 곳이 없음을 나타내는 boolean 변수

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited.contains(arr[nx][ny]))
                continue;

            flag = false;
            visited.add(arr[nx][ny]);
            DFS(nx, ny, temp + 1);
            visited.remove(arr[nx][ny]);
        }

        if (flag)
            result = Math.max(result, temp);
    }
}
