/*
PGS 42586
Stack/Queue
Lv2
기능개발
*/

#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    vector<int> times;
    
    for(int i = progresses.size() - 1; i >= 0  ; i--) {       // developement time
        int time = (99 - progresses[i]) / speeds[i] + 1;
        times.push_back(time);
    }
    
    int cnt = 1;
    int current = times.back();
    times.pop_back();
    
    while(!times.empty()) {
        if(current >= times.back()) {     // top task is also deployed
            cnt++;
        }
        else {      // top task will be deployed in next
            current = times.back();
            answer.push_back(cnt);
            cnt = 1;
        }
        times.pop_back();
    }
    answer.push_back(cnt);
    
    
    return answer;
}