/*
PGS 42626
Heap
더 맵게
Lv2
*/

#include <string>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    
    priority_queue<int, vector<int>, greater<int>> minHeap;
    for(int s: scoville) {
        minHeap.push(s);
    }
    
    while(minHeap.size() >= 2 && minHeap.top() < K) {
        int first = minHeap.top(); minHeap.pop();
        int second = minHeap.top(); minHeap.pop();
        int mixed = first + second * 2;
        minHeap.push(mixed);
        answer++;
    }
    
    if(!minHeap.empty() && minHeap.top() >= K)  return answer;
    else    return -1;
    
    
    return answer;
}