package SeungJi20.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17608 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] len = new int[N];
        int count = 1;
        for(int i=0; i<N; i++){
            len[i]= Integer.parseInt(br.readLine());

        }

        int max = len[N-1]; // 중요
        for(int i=N-2; i>=0; i--){ // 방향성이 중요
        if( max < len[i]){
            max = len[i];
            count += 1;
        }
    }
    System.out.println(count);




        
    }
}
