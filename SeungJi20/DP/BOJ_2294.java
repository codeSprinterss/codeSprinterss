package SeungJi20.DP;

import java.io.*;
import java.util.Arrays;


import static java.lang.Math.min;


public class BOJ_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

//        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coins = new int[n];
//        for(int i=0; i<n; i++){
//            coins[i] = Integer.parseInt(st.nextToken());
//        }

        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1]; // 크기 K+1로 설정
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dp, INF); // 초기화 필수!
        dp[0] = 0;


        for(int i=1; i<=k; i++) {
            for (int a : coins) {
                if(i-a>=0 && dp[i-a]!= INF)
                dp[i] = min(dp[i], dp[i-a]+1); // 두개의 인자값 가능한 이유가 이미 초기화를 해뒀기 때문.
            }
        }
        if (dp[k] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }


    }
}
