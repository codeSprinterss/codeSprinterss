/*
PGS 42628
Heap
이중우선순위큐
Lv3
*/

#include <string>
#include <vector>
#include <set>
using namespace std;

vector<int> solution(vector<string> operations) {
    multiset<int> ms;
    for (auto &op : operations) {
        char cmd;
        int x;
        sscanf(op.c_str(), "%c %d", &cmd, &x); // sscanf
        if (cmd == 'I') {
            ms.insert(x);
        } else if (!ms.empty()) {
            if (x == 1) {
                auto it = prev(ms.end());
                ms.erase(it);
            } else if (x == -1) {
                ms.erase(ms.begin());
            }
        }
    }
    if (ms.empty()) return {0, 0};
    return {*prev(ms.end()), *ms.begin()};
}
