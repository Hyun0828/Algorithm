import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(-1, 0));

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];

            while (stack.peek().val < x) {
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
            }

            if (stack.isEmpty()) {
                System.out.print("0 ");
            } else {
                System.out.print(stack.peek().idx + " ");
            }
            stack.push(new Pair(i + 1, x));
        }
    }

    static class Pair {
        int idx;
        int val;

        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
