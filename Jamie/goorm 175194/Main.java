import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int event[][] = new int[N][2];
		// 1. N개의 배열에 시작시간과 끝 시간을 함께 저장한 뒤 나중에 끝시간 기준으로 정렬할 예정입니다.

		StringTokenizer st;
		// 2. Tokenizer의 경우 선언만 해주고 for문이 돌아가는동안 매번 정의되어야 하기때문에 for문에서 정의해줍니다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			event[i][0] = Integer.parseInt(st.nextToken());
			event[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(event, new Comparator<int[]>(){
			// 3. 자바 강의에 나옵니다! Comparator을 일회성 클래스로 상속해줍니다.
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
                    // '[1]'이니까 끝나는 시간입니다. 만약 끝나는 시간이 같다면
					return o1[0] - o2[0];
                    // 시작시간이 더 빠른순으로 정렬해줍니다 '[0]' 이니까
				} return o1[1] - o2[1];
                // 끝나는 시간 조건입니다.
			}
		});
		
		int count = 0;
        // 4. 카운트를 먼저 선언해주고
		int prev_end_time = 0;
        // 5. 끝나는시간을 미리 담아놓는 변수를 선언해줍니다.
		for (int i = 0; i < N; i++) {
			if (prev_end_time <= event[i][0]) {
                // 6. 처음엔 끝나는시간이 0이니까 웬만하면 조건에 맞습니다. 시작시간과 비교하는겁니다.
				prev_end_time = event[i][1];
                // 7. 그럼 그 조건중 끝나는 시간을 변수에 담아줍니다.
				count ++;
                // 8. 1번 담겼으니가 카운트 1증가
				prev_end_time += 1;
                // 9. 끝나고 1시간 뒤에 예약한다고 했으니까 현재 끝나는 시간1증가
			}
		}
		System.out.print(count); // 카운트 구해주면 끝납니다.
	}
}