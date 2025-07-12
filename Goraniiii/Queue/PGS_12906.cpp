/*
PGS 12906
Stack/Queue
Lv1
같은 숫자는 싫어
*/

#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    for(int a : arr) {
        if (answer.empty()) {
            answer.push_back(a);
        }
        else {
            if(a != answer.back()) {
                answer.push_back(a);
            }
        }
    }

    return answer;
}