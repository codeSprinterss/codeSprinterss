package SeungJi20.BFS;

import java.util.*;

public class BOJ_1260 {
    public static void main(String[] args) {
        List<List<Integer>> myList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int v = sc.nextInt();


        for(int i=0; i<=N; i++){
            myList.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            myList.get(a).add(b);
            myList.get(b).add(a);
        }
        



    }
    
}
