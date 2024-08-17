import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static Queue<Point> queue;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] fish_visited;
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static Point shark;
    static int shark_weight = 2;
    static int shark_ate = 0;
    static int time = 0;

    static PriorityQueue<Fish> fish;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = new int[n];
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 9)
                    shark = new Point(i, j, 0);
            }
        }

        boolean isHelp = false;
        while (!isHelp) {
            calculateDistance();
            copy();
            eat();
            isHelp = isEnd();
        }
        System.out.println(time);
    }

    private static void print() {
        for (Fish f : fish) {
            System.out.print("x = " + f.x);
            System.out.print(", y = " + f.y);
            System.out.print(", distance = " + f.distance);
            System.out.println(", weight = " + f.weight);
        }
    }

    private static void copy() {
        PriorityQueue<Fish> temp = new PriorityQueue<>();

        while (!fish.isEmpty())
            temp.add(fish.poll());
        while (!temp.isEmpty())
            fish.add(temp.poll());
    }

    private static void calculateDistance() {

        queue = new LinkedList<>();
        visited = new boolean[n][n];
        fish_visited = new boolean[n][n];
        fish = new PriorityQueue<>();

        queue.offer(shark);
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int x = now.x;
            int y = now.y;
            int dis = now.distance;

            if (visited[x][y])
                continue;
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int ndis = dis + 1;
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (!fish_visited[nx][ny] && map[nx][ny] >= 1 && map[nx][ny] <= 6) {
                    fish.offer(new Fish(nx, ny, map[nx][ny], ndis));
                    fish_visited[nx][ny] = true;
                }
                if (map[nx][ny] > shark_weight) {
                    continue;
                }
                queue.offer(new Point(nx, ny, ndis));
            }
        }
    }

    private static void eat() {

        for (Fish f : fish) {
            if (f.weight >= shark_weight)
                continue;

            map[f.x][f.y] = 0;
            map[shark.x][shark.y] = 0;
            shark.x = f.x;
            shark.y = f.y;
            shark.distance = 0;

            time += f.distance;

            shark_ate++;
            if (shark_ate == shark_weight) {
                shark_weight++;
                shark_ate = 0;
            }
            return;
        }
    }

    private static boolean isEnd() {

        if (fish.isEmpty())
            return true;
        else {
            for (Fish fish : fish) {
                if (fish.weight < shark_weight)
                    return false;
            }
        }
        return true;
    }
}

class Point {
    int x;
    int y;
    int distance;

    public Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

class Fish implements Comparable<Fish> {
    int x;
    int y;
    int weight;
    int distance;

    public Fish(int x, int y, int weight, int distance) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.distance = distance;
    }

    @Override
    public int compareTo(Fish fish) {
        if (this.distance != fish.distance) {
            return Integer.compare(this.distance, fish.distance);
        } else if (this.x != fish.x) {
            return Integer.compare(this.x, fish.x);
        } else {
            return Integer.compare(this.y, fish.y);
        }
    }
}
