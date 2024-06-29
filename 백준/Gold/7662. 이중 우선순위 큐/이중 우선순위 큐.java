import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            Queue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Integer> min_heap = new PriorityQueue<>();
            int k = Integer.parseInt(reader.readLine());
            for (int j = 0; j < k; j++) {
                String[] s = reader.readLine().split(" ");
                if (s[0].equals("I")) {
                    if (!map.containsKey(Integer.parseInt(s[1])))
                        map.put(Integer.parseInt(s[1]), 1);
                    else
                        map.replace(Integer.parseInt(s[1]), map.get(Integer.parseInt(s[1])) + 1);
                    max_heap.add(Integer.parseInt(s[1]));
                    min_heap.add(Integer.parseInt(s[1]));
                } else if (s[0].equals("D")) {
                    if (Integer.parseInt(s[1]) == 1) {
                        if (!max_heap.isEmpty()) {
                            Integer data = max_heap.poll();
                            map.replace(data, map.get(data) - 1);
                        }
                    } else if (Integer.parseInt(s[1]) == -1) {
                        if (!min_heap.isEmpty()) {
                            Integer data = min_heap.poll();
                            map.replace(data, map.get(data) - 1);
                        }
                    }
                    // 동기화
                    while (!max_heap.isEmpty() && map.get(max_heap.peek()) <= 0) {
                        max_heap.poll();
                    }
                    while (!min_heap.isEmpty() && map.get(min_heap.peek()) <= 0) {
                        min_heap.poll();
                    }
                }
            }
            if (max_heap.isEmpty() && min_heap.isEmpty())
                System.out.println("EMPTY");
            else
                System.out.println(max_heap.peek() + " " + min_heap.peek());
        }
    }
}