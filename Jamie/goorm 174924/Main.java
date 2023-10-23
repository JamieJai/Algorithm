import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[n];
		int max = Integer.MIN_VALUE;
        // 0을 사용해도 관계 없으나 음수가 나올 경우 대비함
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		for (int i = 0; i < n; i++) {
			int cnt = arr[i];
			for (int j = i; j < n-1; j++) { 
				
				if (arr[j+1] == arr[j] + 1) { 
                    // [j+1] 이라는 조건 때문에 j의 for문 조건 값을 n-1로 줌
					cnt += arr[j+1];
				} else {
					break;
				}
				max = Math.max(cnt, max);
			}
		}
		System.out.print(max);
        // 원래는 br.write 사용해야 하지만 구현이 복잡한 문제 아니므로 패스
	}
}