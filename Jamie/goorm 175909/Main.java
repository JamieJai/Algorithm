import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> set = new HashSet<>();
        // 배열의 중복을 물어보는 문제이기 때문에 HashSet을 사용하면 편리합니다.

		int[] arr = new int[M];
		
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
        // 1. 일단 모든 문자열 배열에 담습니다.
	
		int answer = -1;
        // 2. 기본값을 -1로 설정하는 이유는 조건에 만족 되지 않으면 그대로 출력하기 위함입니다.
	
		for (int i = 0; i < M; i++) {
			set.add(arr[i]);
			if (set.size() == N) {
				answer = i+1;
				break;
			}
            // 3. HashSet에는 중복이 담기지 않으므로 최종 사이즈를 N과 비교합니다.
		}	
		System.out.print(answer);
        // 4. 조건에 맞지 않으면 -1이 출력 될 것입니다.
	}
}
