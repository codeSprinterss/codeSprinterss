package SeungJi20.BFS;

import java.io.*;
import java.util.*;

public class BOJ_2606 {
    static ArrayList<Integer>[] graph; // 연결 정보를 저장할 그래프
    static boolean[] visited; // 방문 여부 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int m = Integer.parseInt(br.readLine()); // 연결 수

        graph = new ArrayList[n + 1]; // 인덱스를 1부터 쓰기 위해 n+1
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 연결 정보 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a); // 양방향 연결
        }

        visited = new boolean[n + 1]; // 방문 여부 배열

        int result = bfs(1); // 1번 컴퓨터부터 시작

        System.out.println(result); // 1번 제외한 감염된 컴퓨터 수 출력
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start); // 큐에 추가

        int count = 0; // 감염된 컴퓨터 수

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 큐에서 꺼냄

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true; // 방문 처리
                    queue.offer(next); // 큐에 추가
                    count++; // 감염된 컴퓨터 수 증가
                }
            }
        }

        return count;
    }
}

