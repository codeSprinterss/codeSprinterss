package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 분수찾기1193 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        br.close();

        int squareCount = 1;
        int squareSum =  0;

        while(true){
            if(X <= squareSum + squareCount){
                if(squareCount % 2 == 1){
                    System.out.println((squareCount-(X - squareSum -1) + "/" + (X - squareSum)));
                    break;
                }else{
                    System.out.println((X - squareSum) + "/" + (squareCount-(X - squareSum -1)));
                    break;
                }
            }else{
                squareSum += squareCount;
                squareCount++;
            }
        }

    }
    }
}
