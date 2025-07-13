package SeungJi20.DP;

import java.io.*;


public class PGS_멀리뛰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int mod = 1234567;

        if(N==1){
            dp[0] = 1;
            System.out.println(dp[0]);
            return;
        }

        if(N==2){
            dp[0] = 1;
            dp[1] = 2;
            System.out.println(dp[1]);
            return;
        }

        else{
            dp[0] = 1;
            dp[1] = 2;
            for(int i=2; i<N; i++){
                dp[i] = (dp[i-1]+dp[i-2]) % mod;;
            }
            System.out.println(dp[N-1]);
        }







    }
}
