package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int left = 1;
        int right = trees[N-1];

        while(left>right){
            int mid = (left+right)/2;
            int sum = 0;

            for(int i=0; i<N; i++){
                sum += trees[i]-mid;
            }

            if(sum==M){
                break;
            }
            else if(sum>M){

            }

        }


    }
}
