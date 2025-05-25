package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15903 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t = br.readLine().split(" ");

        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);

        long[] deck = new long[n];
        StringTokenizer eleCard = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            deck[i] = Long.parseLong(eleCard.nextToken());
        }

        Arrays.sort(deck);

        for(int j=0; j<m; j++){
            long sum = deck[0]+deck[1];
            deck[0] = sum;
            deck[1] = sum;
            Arrays.sort(deck);
        }

        long answer=0;

        for(int i=0; i<n; i++){
            answer += deck[i];
        }

        System.out.println(answer);
    }
}
