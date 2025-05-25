package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2302 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());


        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        int answer = 1;
        int vip = 0;

        for(int i=0; i<M; i++){
            int temp = Integer.parseInt(br.readLine());
            answer *= dp[temp-vip - 1];
            vip = temp;
        }
        answer *= dp[N - vip];

        System.out.print(answer);
    }
}
