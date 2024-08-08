import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[] A;
    static int[] B;
    static int n;
    static int m;

    static List<Value> common_Array = new ArrayList<Value>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        A = new int[n];
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(input[i]);
        m = Integer.parseInt(reader.readLine());
        B = new int[m];
        input = reader.readLine().split(" ");
        for (int i = 0; i < m; i++)
            B[i] = Integer.parseInt(input[i]);

        CS();

        System.out.println(common_Array.size());
        for (Value value : common_Array)
            System.out.print(value.value + " ");
    }

    private static void CS() {

        while (true) {
            Value value = find_Common();
            if (value.idx_A == -1 && value.idx_B == -1) // 더 이상 공통 숫자가 없을 때
                break;

            boolean is_correct = true;
            if (!common_Array.isEmpty()) {
                // 이전 선택 숫자보다 앞에서 고른 숫자는 적용할 수 없다.
                if (common_Array.get(common_Array.size() - 1).idx_A > value.idx_A) {
                    A[value.idx_A] = -1;
                    is_correct = false;
                }
                if (common_Array.get(common_Array.size() - 1).idx_B > value.idx_B) {
                    B[value.idx_B] = -1;
                    is_correct = false;
                }

                if (!is_correct)
                    continue;
            }

            A[value.idx_A] = -1;
            B[value.idx_B] = -1;
            common_Array.add(value);
        }
    }

    private static Value find_Common() {

        int max = 0;
        int idx_A = -1;
        int idx_B = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i] == B[j]) {
                    if (max < A[i]) {
                        max = A[i];
                        idx_A = i;
                        idx_B = j;
                    }
                }
            }
        }

        return new Value(max, idx_A, idx_B);
    }
}

class Value {
    int value;
    int idx_A;
    int idx_B;

    public Value(int value, int idx_A, int idx_B) {
        this.value = value;
        this.idx_A = idx_A;
        this.idx_B = idx_B;
    }
}
