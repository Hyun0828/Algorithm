import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            BFS(a, b);
        }
    }

    public static void BFS(int a, int b) {
        Queue<Register> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        Register register = new Register(a);
        q.offer(register);
        visited.add(a);

        while (!q.isEmpty()) {
            Register current = q.poll();
            if (current.a == b) {
                System.out.println(current.sb.toString());
                return;
            }

            Register next;

            next = current.D();
            if (next.a == b) {
                System.out.println(next.sb.toString());
                return;
            }
            if (!visited.contains(next.a)) {
                q.offer(next);
                visited.add(next.a);
            }


            next = current.S();
            if (next.a == b) {
                System.out.println(next.sb.toString());
                return;
            }
            if (!visited.contains(next.a)) {
                q.offer(next);
                visited.add(next.a);
            }

            next = current.L();
            if (next.a == b) {
                System.out.println(next.sb.toString());
                return;
            }
            if (!visited.contains(next.a)) {
                q.offer(next);
                visited.add(next.a);
            }

            next = current.R();
            if (next.a == b) {
                System.out.println(next.sb.toString());
                return;
            }
            if (!visited.contains(next.a)) {
                q.offer(next);
                visited.add(next.a);
            }
        }
    }
}

class Register {
    public int a;
    public StringBuilder sb;

    public Register(int a) {
        this.a = a;
        sb = new StringBuilder();
    }

    public Register(int a, StringBuilder sb) {
        this.a = a;
        this.sb = sb;
    }

    public Register D() {
        StringBuilder nsb = new StringBuilder(sb);
        nsb.append("D");
        int na = (a * 2) % 10000;

        return new Register(na, nsb);
    }

    public Register S() {
        StringBuilder nsb = new StringBuilder(sb);
        nsb.append("S");
        int na = 0;
        if (a == 0)
            na = 9999;
        else
            na = a - 1;

        return new Register(na, nsb);
    }

    public Register L() {
        StringBuilder nsb = new StringBuilder(sb);
        nsb.append("L");
        int result = (a % 1000) * 10 + a / 1000;

        return new Register(result, nsb);
    }

    public Register R() {
        StringBuilder nsb = new StringBuilder(sb);
        nsb.append("R");
        int result = (a % 10) * 1000 + a / 10;

        return new Register(result, nsb);
    }
}