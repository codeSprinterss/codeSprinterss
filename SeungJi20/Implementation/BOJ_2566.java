package SeungJi20.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2566 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        int x=0;
        int y=0;
        int max = Integer.MIN_VALUE; // 초기값을 arr[0][0]으로 하게 되는경우,
        // 만약 입력에 음수가 있을 경우 최댓값 비교가 제대로 안됨 주의. 
        for(int i=0; i<9; i++){
            String[] input = br.readLine().split(" "); // 한줄 통째로 읽기

            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(input[j]);

            }
        }
        for(int i =0; i<9; i++){
            for(int j=0; j<9; j++){
                if(arr[i][j]>max){
                    max = arr[i][j];
                    x=i+1;
                    y=j+1;
                }
            }
        }
        System.out.println(max);
        System.out.println(x+" "+y);
    }
}
