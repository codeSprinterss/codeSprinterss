package SeungJi20.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2605 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()); // split 말고 사용
        ArrayList<Integer> line = new ArrayList();

        for(int i=0; i<N; i++){
            int move = Integer.parseInt(st.nextToken());
            line.add(i - move, i + 1);
            // 현재 학생 번호는 i+1 (1번부터 시작), 앞에서 move만큼 앞으로 삽입
        }      


        for (int num : line) {
            System.out.println(num + " ");
        }

    }
}

