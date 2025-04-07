import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int L;
    static Map<Integer, Character> dirMap = new HashMap<>();

    static int[][] map;
    static char snakeDirection; // E,W,S,N
    static Deque<Point> snakePositions;
    static Point head;
    static Point tail;
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        map = new int[N + 1][N + 1];
        K = Integer.parseInt(reader.readLine());
        for (int i = 0; i < K; i++) {
            String[] input = reader.readLine().split(" ");
            int y = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            map[y][x] = 1;
        }
        L = Integer.parseInt(reader.readLine());
        for (int i = 0; i < L; i++) {
            String[] input = reader.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            char direction = input[1].charAt(0);
            dirMap.put(time, direction);
        }

        snakeDirection = 'E';
        snakePositions = new LinkedList<>();
        head = new Point(1, 1);
        tail = new Point(1, 1);
        time = 1;
        snakePositions.add(head);
        solve();

        System.out.println(time);
    }

    public static void solve() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int y = current.y;
            int x = current.x;

            int nextY = y;
            int nextX = x;
            if (snakeDirection == 'E') {
                nextX += 1;
            } else if (snakeDirection == 'W') {
                nextX -= 1;
            } else if (snakeDirection == 'S') {
                nextY += 1;
            } else if (snakeDirection == 'N') {
                nextY -= 1;
            }
            // 벽이거나 내 몸과 부딪히면 끝
            if (nextY == 0 || nextX == 0 || nextY == N + 1 || nextX == N + 1 || snakePositions.contains(new Point(nextX, nextY))) {
                return;
            }

            // 이동을 한다.
            head = new Point(nextX, nextY);
            snakePositions.addFirst(head);
            queue.add(head);

            // 사과가 있다면
            if (map[nextY][nextX] == 1) {
                map[nextY][nextX] = 0;
            }
            // 사과가 없이 이동만 하면
            else {
                // 꼬리 이동
                snakePositions.removeLast();
            }

            // X초가 끝난 뒤에 방향을 회전한다.
            if (dirMap.containsKey(time)) {
                if (dirMap.get(time) == 'L') {
                    if (snakeDirection == 'E') {
                        snakeDirection = 'N';
                    } else if (snakeDirection == 'W') {
                        snakeDirection = 'S';
                    } else if (snakeDirection == 'S') {
                        snakeDirection = 'E';
                    } else if (snakeDirection == 'N') {
                        snakeDirection = 'W';
                    }
                } else if (dirMap.get(time) == 'D') {
                    if (snakeDirection == 'E') {
                        snakeDirection = 'S';
                    } else if (snakeDirection == 'W') {
                        snakeDirection = 'N';
                    } else if (snakeDirection == 'S') {
                        snakeDirection = 'W';
                    } else if (snakeDirection == 'N') {
                        snakeDirection = 'E';
                    }
                }
            }
            time++;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }
    }
}