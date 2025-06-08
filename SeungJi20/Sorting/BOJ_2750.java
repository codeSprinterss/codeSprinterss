package SeungJi20.Sorting;

import java.io.*;

public class BOJ_2750 {
    public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];

            for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            }
            
            // 버블 정렬
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < N - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }
            br.close();
            bw.close();
      
        }
}
