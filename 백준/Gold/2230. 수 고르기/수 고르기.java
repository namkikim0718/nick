import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // A를 오름차순으로 정렬
        Arrays.sort(A);

        // 왼쪽 포인터
        int lt = 0;
        // 오른쪽 포인터
        int rt = 1;
        // result는 아주 큰 수로 초기화
        int result = Integer.MAX_VALUE;
        
        // lt가 rt보다 작거나 같은 동안 반복
        while (lt <= rt) {
            // 각 요소의 차이
            int dist = A[rt] - A[lt];

            // 요소의 차이가 M보다 크거나 같으면 result와 비교 후 저장
            // lt 는 1 증가
            if (dist >= M) {
                result = Math.min(result, dist);
                lt++;
            } else { 
                // rt가 끝지점에 도달하면 break
                if (rt == N-1) {
                    break;
                }
                rt++;
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}
