package DP;

import java.io.*;
import java.util.*;

public class 점프점프11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] jump = new int[n + 1];
        int[] dist = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            jump[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int maxJump = jump[cur];
            for (int i = 1; i <= maxJump; i++) {
                int next = cur + i;
                if (next > n) break;
                if (dist[next] == 0) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        System.out.println(dist[n] == 0 ? -1 : dist[n] - 1); // 시작이 1부터니까 -1
    }
}
