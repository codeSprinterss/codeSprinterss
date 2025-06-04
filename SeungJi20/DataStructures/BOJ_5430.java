package SeungJi20.DataStructures;

import java.io.*;
import java.util.*;

public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder(); // 최종 출력 저장
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine()); // 배열 길이
            String arrInput = br.readLine();

            // 배열 파싱
            arrInput = arrInput.substring(1, arrInput.length() - 1); // 대괄호 제거
            String[] nums = arrInput.split(",");
            ArrayList<Integer> list = new ArrayList<>();

            if (n != 0) {
                for (String num : nums) {
                    list.add(Integer.parseInt(num));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else if (cmd == 'D') {
                    if (list.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (isReversed) {
                            list.remove(list.size() - 1); // 뒤에서 삭제
                        } else {
                            list.remove(0); // 앞에서 삭제
                        }
                    }
                }
            }

            if (isError) {
                output.append("error\n");
            } else {
                if (isReversed) {
                    Collections.reverse(list);
                }
                output.append("[");
                for (int i = 0; i < list.size(); i++) {
                    output.append(list.get(i));
                    if (i != list.size() - 1) output.append(",");
                }
                output.append("]\n");
            }
        }

        // 최종 출력
        System.out.print(output);
    }
}