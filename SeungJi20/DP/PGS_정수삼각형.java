package SeungJi20.DP;
import java.io.*;
import java.util.*;


import static java.lang.Math.max;



public class PGS_정수삼각형 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            triangle.add(new ArrayList<>());
        }

//        for(List<Integer> list : triangle){
//            list.add(Integer.parseInt(br.readLine()));
//        }
        // 위 처럼 하면 한줄에 한개씩밖에 안들어와서 삼각형 형태가 될 수가 없음
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            for (String p : parts) {
                triangle.get(i).add(Integer.parseInt(p));
            }
        }

        int[][] dp = new int[n][n]; // 2차원 배열로!!
        dp[0][0] = triangle.get(0).get(0);
        int INF = Integer.MIN_VALUE;

//        Arrays.fill(dp, INF);
        // Arrays.fill() 은 1차원 배열에서만 동작함

//        if(triangle.size()==1){
//            System.out.println(triangle.get(0).get(0));
//        }
////        if(triangle.size()==2){
////            System.out.println(triangle.get(0).get(0) + max(triangle.get(1).get(0), triangle.get(1).get(1)));
////        }
//        // 2줄 이상일 때 따로 처리할 필요 없음. dp로 돌리면 됨.
//
//        else{
//            dp[0][0]  = triangle.get(0).get(0);
//
//            for(int i=1; i<triangle.size(); i++){
//                for(int j=0; j<i+1; j++){
//                    dp[i][j] = max(dp[i-1][j]+dp[i][j], dp[i-1][j]+dp[i][j+1]);
//                }
//            }
//
//        }

        // 맨왼쪽(j=0)일때는 위에서만 옴. 맨오른쪽(j=i)일때는 왼쪽 위에서만 옴
        // 나머지 경우가 두 군데에서 올 수 있음
        // 따라서
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }


        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = max(answer, dp[n - 1][i]);
        }
        System.out.println(answer);
    }
}
