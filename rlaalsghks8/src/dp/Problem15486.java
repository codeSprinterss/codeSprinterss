package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15486 {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] consult = new int[2][N];
        int[] dp = new int[N + 1];



        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            consult[0][i] = Integer.parseInt(st.nextToken());
            consult[1][i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            int nextDay = i + consult[0][i];
            // i번째 상담을 끝내고 나서 날짜가 범위 내일 때만
            if(nextDay <= N){
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + consult[1][i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]); // 상담을 안 했을 경우도 고려
        }

        System.out.println(dp[N]);
    }
}
