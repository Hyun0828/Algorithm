import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(reader.readLine());
            pq.add(a);
        }

        int result = 0;
        int temp = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            temp += pq.poll();
            count++;

            if (count == 2) {
                pq.add(temp);
                result += temp;
                count = 0;
                temp = 0;
            }
        }
        System.out.println(result);
    }
}