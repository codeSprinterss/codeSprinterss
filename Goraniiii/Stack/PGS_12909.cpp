/*
PGS 12909
Stack/Queue
Lv2
올바른 괄호
*/

#include<string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    
    int check = 0;

    for(int i = 0; i < s.length(); i++) {
        if(s[i] == '(') {
            check++;
        }
        else {
            if(check > 0) {
                check--;
            }
            else {
                answer = false;
                break;
            }
        }
    }
    if(check > 0) {
        answer = false;
    }

    return answer;
}