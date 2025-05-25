/*
PGS 42862
Greedy
체육복
Lv1
*/

#include <algorithm>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());
    
    vector<bool> removedLost(lost.size(), false);
    vector<bool> removedRes(reserve.size(), false);
    
    for (int i = 0; i < (int)lost.size(); ++i) {
        for (int j = 0; j < (int)reserve.size(); ++j) {
            if (!removedLost[i] && !removedRes[j] && lost[i] == reserve[j]) {
                removedLost[i] = removedRes[j] = true;
                break;
            }
        }
    }
    
    vector<int> lostOnly, resOnly;
    for (int i = 0; i < (int)lost.size(); ++i) {
        if (!removedLost[i]) {
            lostOnly.push_back(lost[i]);
        }
    }
        
    for (int j = 0; j < (int)reserve.size(); ++j){
        if (!removedRes[j]){
            resOnly.push_back(reserve[j]);
        }
    }
    
    int unable = 0;
    for (int l : lostOnly) {
        auto it = find(resOnly.begin(), resOnly.end(), l-1);
        if (it != resOnly.end()) {
            resOnly.erase(it);
        } else {
            it = find(resOnly.begin(), resOnly.end(), l+1);
            if (it != resOnly.end()) {
                resOnly.erase(it);
            } else {
                unable++;
            }
        }
    }
    
    return n - unable;
}
