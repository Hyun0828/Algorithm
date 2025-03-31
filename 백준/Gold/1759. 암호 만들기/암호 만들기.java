import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L = 0;
    static int C = 0;
    static char[] arr;
    static Set<String> result = new TreeSet<>();
    static Set<Character> mo = new HashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        L = Integer.parseInt(input.split(" ")[0]);
        C = Integer.parseInt(input.split(" ")[1]);
        arr = new char[C];
        String[] temp = reader.readLine().split(" ");
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i].charAt(0);
        }

        Arrays.sort(arr);

        mo.add('a');
        mo.add('e');
        mo.add('i');
        mo.add('o');
        mo.add('u');

        for (int i = 0; i <= C - 4; i++) {
            dfs(new StringBuilder(), i, 0, 0, 0);
        }

        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void dfs(StringBuilder sb, int idx, int count, int numOfM, int numOfJ) {
        if (count == L && numOfM >= 1 && numOfJ >= 2) {
            result.add(sb.toString());
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            // 모음이면
            if (mo.contains(arr[i])) {
                dfs(sb.append(arr[i]), i + 1, count + 1, numOfM + 1, numOfJ);
                sb.deleteCharAt(sb.length() - 1);
            }
            // 자음이면
            else {
                dfs(sb.append(arr[i]), i + 1, count + 1, numOfM, numOfJ + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}