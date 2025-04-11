import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);
        int y = Integer.parseInt(input[3]);
        int K = Integer.parseInt(input[4]);

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] direction = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dice = new int[7]; // 주사위에 적힌 숫자
        int[] halfDice = new int[3]; // 앞쪽, 오른쪽, 아래의 전개도 번호

        halfDice[0] = 5;
        halfDice[1] = 3;
        halfDice[2] = 6;

        for (int i = 0; i < direction.length; i++) {
            int dir = direction[i];
            if (dir == 1) {
                if (y + 1 >= M)
                    continue;
                y++;
            } else if (dir == 2) {
                if (y - 1 < 0)
                    continue;
                y--;
            } else if (dir == 3) {
                if (x - 1 < 0)
                    continue;
                x--;
            } else if (dir == 4) {
                if (x + 1 >= N)
                    continue;
                x++;
            }

            // 1. 이동하고 주사위의 방향을 계산한다.
            // 동
            if (dir == 1) {
                int temp = halfDice[2];
                halfDice[2] = halfDice[1];
                halfDice[1] = 7 - temp;
            }
            // 서
            else if (dir == 2) {
                int temp = halfDice[2];
                halfDice[2] = 7 - halfDice[1];
                halfDice[1] = temp;
            }
            // 북
            else if (dir == 3) {
                int temp = halfDice[2];
                halfDice[2] = 7 - halfDice[0];
                halfDice[0] = temp;
            }
            // 남
            else if (dir == 4) {
                int temp = halfDice[2];
                halfDice[2] = halfDice[0];
                halfDice[0] = 7 - temp;
            }
            int underDiceNumber = halfDice[2];

            /*
                앞, 오른, 아래
                5,3,6

                동쪽 : 5, [1], 3 -> 앞은 그대로, 오른쪽이 아래로가고 아래의 반대쌍이 오른쪽으로
                서쪽 : 5, 6, [4] -> 앞은 그대로, 아래가 오른쪽으로 가고 오른의 반대쌍이 아래로
                남쪽 : [1], 3, 5 -> 오른쪽은 그대로, 앞이 아래로 가고 아래의 반대쌍이 앞으로
                북쪽 : 6, 3, [2] -> 오른쪽은 그대로, 아래가 앞으로 가고 앞의 반대쌍이 아래로
             */

            // 2. 이동하고 지도에 써진 숫자를 확인한다.
            int mapValue = map[x][y];

            // 3. 지도에 0이 써져있다면 주사위 밑면의 값을 복사한다.
            if (mapValue == 0) {
                map[x][y] = dice[underDiceNumber];
            }
            // 4. 0이 아니라면 주사위 바닥면으로 값을 복사한다.
            else {
                dice[underDiceNumber] = mapValue;
                map[x][y] = 0;
            }

            System.out.println(dice[7 - underDiceNumber]);
        }
    }
}