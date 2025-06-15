package SeungJi20.Implementation;

import java.io.*;

public class BOJ_2562 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
         int max = arr[0]; // for문 밖에서 선언
         int index = 0; // for문 밖에서 선언
        for(int i=0; i<9; i++){
            arr[i] =  Integer.parseInt(br.readLine());
            if(max<arr[i]){
                max = arr[i];
                index = i;
            }
              
        }
         System.out.println(max);
         System.out.println(index);
       

    }

}
