package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 피보나치함수1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] dp = new int[41][2]; // dp[i][0]: fibonacci(i) 호출 시 0 출력 횟수, [i][1]: 1 출력 횟수
        dp[0][0] = 1; // fibonacci(0) → 0 한 번 출력
        dp[1][1] = 1; // fibonacci(1) → 1 한 번 출력

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
