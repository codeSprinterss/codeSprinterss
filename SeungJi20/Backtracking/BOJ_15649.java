package SeungJi20.Backtracking;

import java.util.*;
import java.io.*;

public class BOJ_15649 {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        List<Integer> myList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            myList.add(i);
        }

        visited = new boolean[N];
        List<List<Integer>> doubleList = new ArrayList<>();
        permu(myList, new ArrayList<>(), doubleList, M, visited);

        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : doubleList) {
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void permu(List<Integer> myList, List<Integer> temp,
                             List<List<Integer>> doubleList, int target, boolean[] visited) {
        if (temp.size() == target) {
            doubleList.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < myList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(myList.get(i));
                permu(myList, temp, doubleList, target, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
