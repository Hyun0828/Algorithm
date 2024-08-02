import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<Integer> queue = new LinkedList<>();
    static int[] time = new int[100001];
    static int count = 0;
    static int min_time = 99999999;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        if (n >= k) {
            System.out.println(n - k);
            System.out.println("1");
        }
        else {
            BFS();
            System.out.println(min_time);
            System.out.println(count);
        }
    }

    public static void BFS() {

        queue.offer(n);
        time[n] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            // 더 오래 걸리니까 이후는 볼 필요가 없다.
            if (min_time < time[now])
                return;

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0)
                    next = now - 1;
                else if (i == 1)
                    next = now + 1;
                else
                    next = now * 2;

                if (next < 0 || next > 100000)
                    continue;

                // 동생을 만났을 때
                if (next == k) {
                    min_time = time[now];
                    count++;
                }

                // 아직 방문하지 않은 노드이거나 같은 시간에 방문했다면 큐에 넣는다.
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    queue.offer(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}