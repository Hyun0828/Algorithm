import java.io.*;
import java.util.Stack;

public class Main {

    static char[] arr;
    static Stack<Character> stack = new Stack<>();
    static char[] op = {'+', '-', '*', '/'};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = reader.readLine().toCharArray();

        postFix(writer);
        writer.flush();
    }

    private static boolean contain(char c) {
        for (char temp : op) {
            if (temp == c)
                return true;
        }
        return false;
    }

    private static void postFix(BufferedWriter writer) throws IOException {

        for (char c : arr) {
            if (Character.isLetter(c))
                writer.append(c);
            else if (c == '+' || c == '-') {
                while (!stack.isEmpty()) {
                    if (contain(stack.peek()))
                        writer.append(stack.pop());
                    else
                        break;
                }
                stack.push(c);
            } else if (c == '*' || c == '/') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '*' || stack.peek() == '/')
                        writer.append(stack.pop());
                    else
                        break;
                }
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() != '(')
                        writer.append(stack.pop());
                    else {
                        stack.pop();
                        break;
                    }
                }
            }
        }

        while (!stack.isEmpty())
            writer.append(stack.pop());
    }
}
