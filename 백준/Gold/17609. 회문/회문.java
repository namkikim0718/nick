import java.util.*;
import java.io.*;

public class Main {

    // 회문 검사 함수
    public static boolean isPalindrome(String str, int lt, int rt) {
        // lt와 rt와 만나면 중단
        while (lt < rt) {
            // 하나라도 다르면 회문이 아님
            if (str.charAt(lt) != str.charAt(rt)) {
                return false;
            }
            lt++;
            rt--;
        }
        return true;
    }

    // 유사 회문 검사 함수
    public static boolean isPseudoPalindrome(String str, int lt, int rt) {
        // lt와 rt가 만나면 중단
        while (lt < rt) {
            // 왼쪽 포인터와 오른쪽 포인터의 값이 다를 때
            // 하나 삭제한 나머지가 회문이면 유사 회문으로 판단
            if (str.charAt(lt) != str.charAt(rt)) {
                if (isPalindrome(str, lt + 1, rt) || isPalindrome(str, lt, rt - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
            lt++;
            rt--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String str = br.readLine();

            // 왼쪽 포인터
            int lt = 0;
            // 오른쪽 포인터
            int rt = str.length() - 1;

            if (isPalindrome(str, lt, rt)) {
                sb.append(0 + "\n"); // 회문이면 0 추가
            } else if (isPseudoPalindrome(str, lt, rt)) {
                sb.append(1 + "\n"); // 유사회문이면 1 추가
            } else {
                sb.append(2 + "\n"); // 회문이 아니면 2 추가
            }
        }        

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}
