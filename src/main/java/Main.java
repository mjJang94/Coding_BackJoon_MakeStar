import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * --문제
 * 재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
 * <p>
 * 크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
 * <p>
 * ***
 * * *
 * ***
 * <p>
 * N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
 * <p>
 * --입력
 * 첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.
 * <p>
 * --출력
 * 첫째 줄부터 N번째 줄까지 별을 출력한다.
 */
public class Main {

    static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        arr = new char[N][N];

        StringBuilder stringBuilder = new StringBuilder();

        star(0, 0, N, false);

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                stringBuilder.append(arr[i][j]);
            }
         stringBuilder.append('\n');
        }

        System.out.print(stringBuilder);

    }


    static void star(int x, int y, int N, boolean blank) {


        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }

            return;
        }

        if (N == 1) {
            arr[x][y] = '*';

            return;
        }


        int size = N / 3;
        int count = 0;

        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {

                count++;

                if (count == 5) {
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }
    }


}


