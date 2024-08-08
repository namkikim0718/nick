import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // result의 초기값은 매우 큰값으로 설정
        int result = Integer.MAX_VALUE;
        // 왼쪽 포인터
        int lt = 0;
        // 오른쪽 포인터
        int rt = 0;
        // 부분 수열의 합
        int sum = arr[lt];

        // 만약 첫 요소가 S보다 크다면 결과는 무조건 1
        if (sum >= S) result = 1;

        // lt가 rt보다 커지는 순간 break
        while (lt <= rt) {
            if (sum < S) { // 합이 S보다 작으면 rt한칸 이동
                // 합이 S보다 작은데 rt가 마지막 원소라면 break
                if (rt == N - 1) break;
                sum += arr[++rt];
            } else {       // 합이 S보다 크거나 같으면 lt 한칸 이동
                sum -= arr[lt++];
            }

            // 합이 S이상이면 길이 계산 후 result보다 작으면 저장
            if (sum >= S) {
                int length = rt - lt + 1;
                result = Math.min(result, length);
            }
        }

        // result가 수열의 최대 길이보다 크다면 0으로 변경
        if (result > N) {
            result = 0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result);


        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}