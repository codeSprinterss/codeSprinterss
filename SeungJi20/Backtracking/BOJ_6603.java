package SeungJi20.Backtracking;

import java.io.*;
import java.util.*;

public class BOJ_6603 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            if (k == 0) break;

            List<Integer> myList = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                myList.add(Integer.parseInt(input[i]));
            }

            List<List<Integer>> result = new ArrayList<>();
            combi(myList, new ArrayList<>(), result, 6, 0);

            for (List<Integer> list : result) {
                for (int n : list) {
                    sb.append(n).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void combi(List<Integer> myList, List<Integer> temp, List<List<Integer>> doubleList, int target, int start) {
        if (temp.size() == target) {
            doubleList.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < myList.size(); i++) {
            temp.add(myList.get(i));
            combi(myList, temp, doubleList, target, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
