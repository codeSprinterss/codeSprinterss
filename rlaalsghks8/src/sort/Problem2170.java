package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Problem2170 {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] note = new int[N][2];
        int result = 0;

        for(int i=0; i<N; i++){
            String[] line = br.readLine().split(" ");
            note[i][0] = Integer.parseInt(line[0]);
            note[i][1] = Integer.parseInt(line[1]);
        }

        Arrays.sort(note,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[]o2){
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        //처음 밑줄 정보
        int min = note[0][0];
        int max = note[0][1];
        int len = max - min;


        for(int i=1; i<N; i++){
            if(min<=note[i][0] && note[i][1] <=max){
                continue;
            }else if(note[i][0]<max){
                len += note[i][1]-max;
            }else{
                len += note[i][1] - note[i][0];
            }
            min = note[i][0];
            max = note[i][1];

        }




        System.out.print(len);

    }
}
