/*
PGS 42860
조이스틱
Greedy
Lv2
*/

#include <string>
#include <algorithm>

using namespace std;

int solution(string name) {
    int n = name.size();
    int answer = 0;

    for (char ch : name) {
        int d = ch - 'A';
        answer += min(d, 26 - d);
    }

    int move = n - 1;
    for (int i = 0; i < n; ++i) {
        int next = i + 1;
        while (next < n && name[next] == 'A'){
            next++;
        }
        move = min(move, i + n - next + min(i, n - next));
    }

    return answer + move;
}
