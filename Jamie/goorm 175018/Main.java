/*
 * 설명에 앞서 이건 단순히 피보나치 수열 구하는 문젠데
 * 조금 쓸데없이 long형을 사용하게 만들어 놓았다
 * 핵심은 리스트로 피보나치 수열을 구하는 겁니다.
 * 
 * 리스트로 구하는 이유 - 범위가 정해져 있지 않기때문에...
 * 배열은 칸이 정해져있어서 그렇다고 배열을 10만까지 만드는건 너무 비효율적입니다.
 *  -- 사실 효율은 잘 모르겠습니다 이견있으시면 리뷰 달아주세요! --
 * 배열로도 할 수는 있습니다.
 */
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Long> list = new ArrayList<>();
        // 1. 자료형 받는건 당연하니까 건너 뛰고 리스트를 선언해줍니다.

        if (n == 1) {
            System.out.print("0");
            return;
        } else if (n == 2) {
            System.out.print("1");
            return;
        }
        // 2. 1일때와 2일때는 계산이 어려우므로 사전에 넣어줄 예정이기때문에
        // 만약 n의 값이 1이나 2일때는 몇케이스 안되니까
        // 저렇게 if문 조건 걸어줍니다.

        list.add(0L);
        list.add(1L);
        // 3. 나중에 수열이 커져서 컴파일 에러나니까
        // long형으로 담아줍니다.

        long mod = 1000000007L;
        // 이것도 구름에서 마음에 안드는건데...
        // 갑자기 이런말도안되는 숫자로 나눠주라는 항목 있으니까 잘 보세요

        for (int i = 2; i < n; i++) {
            // 4. 오버플로 방지를 위해 각 단계에서 모듈러 연산 적용
            list.add((list.get(i - 1) + list.get(i - 2)) % mod);
        }   // 5. 조금만 생각하면 쉽습니다 식 그대로입니다.

        System.out.print(list.get(n - 1));
		}
}