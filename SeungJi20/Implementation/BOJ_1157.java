package SeungJi20.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1157 {
    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String word = br.readLine();
    word = word.toUpperCase(); // 새로운 변수 잡을 필요 없음
    // String word = br.readLine().toUpperCase(); 이것도 가능
    int[] alphabet = new int[26];

    for(int i=0; i<word.length(); i++){
        char c = word.charAt(i);
        alphabet[c-'A']++;
    }
    int max = -1;
    char ch = '?';
    for(int i=0; i<26; i++){
        if(alphabet[i]>max){
            max = alphabet[i];
            ch = (char)(i+65);
        
        }else if (alphabet[i] == max){
            ch = '?';
        }
    }
    System.out.println(ch);

}
}