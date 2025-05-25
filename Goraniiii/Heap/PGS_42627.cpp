/*
PGS 42627
Heap
디스크 컨트롤러
Lv3
*/

#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> jobs) {
    sort(jobs.begin(), jobs.end(), 
         [](auto &a, auto &b){  return a[0] < b[0]; });
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minHeap;
    
    int n = jobs.size();
    int i = 0;
    long long currentTime = 0;
    long long totalWait = 0;
    
    while (i < n || !minHeap.empty()) {
        while (i < n && jobs[i][0] <= currentTime) {
            minHeap.push({ jobs[i][1], jobs[i][0] });
            ++i;
        }

        if (!minHeap.empty()) {
            auto [dur, req] = minHeap.top();
            minHeap.pop();
            currentTime += dur;
            totalWait += (currentTime - req);
        } else {
            currentTime = jobs[i][0];
        }
    }

    return totalWait / n;
}