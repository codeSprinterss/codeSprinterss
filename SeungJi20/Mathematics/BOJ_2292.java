package SeungJi20.Mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2292 {
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1); // 1번 방은 1
            return;
        }

        int n = 0;
        while (true) {
            if (3 * n * n + 3 * n + 2 <= N && N < 3 * n * n + 9 * n + 8) {
                System.out.println(n + 2);
                break; 
            }
            n++;
        
        }
    }
}
       
