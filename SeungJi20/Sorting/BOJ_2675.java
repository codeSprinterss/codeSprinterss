package SeungJi20.Sorting;

import java.io.*;

public class BOJ_2675 {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
	
			String[] str = br.readLine().split(" "); // 공백 분리
			
			int R = Integer.parseInt(str[0]);
			String S = str[1]; // 문자열
			
			for(int j = 0; j < S.length(); j++) {
				for(int k = 0; k < R; k++) {
					System.out.print(S.charAt(j));
				}
			}
			System.out.println();
		}
	}
 
	

}