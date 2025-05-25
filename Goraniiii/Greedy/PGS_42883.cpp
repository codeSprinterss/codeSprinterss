/*
PGS 42883
큰 수 만들기
Greedy
Lv2
*/

#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* number, int k) {
    int len = strlen(number);
    int keep = len - k;

    char* stack = (char*)malloc(len + 1);
    int top = 0;

    for (int i = 0; i < len; i++) {
        char c = number[i];
        while (top > 0 && k > 0 && stack[top - 1] < c) {
            top--;
            k--;
        }
        stack[top++] = c;
    }

    top = keep;
    stack[keep] = '\0';

    char* answer = (char*)malloc(keep + 1);
    memcpy(answer, stack, keep + 1);

    free(stack);
    return answer;
}
