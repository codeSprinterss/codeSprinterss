/*
BOJ 1389
Graph
S1
케빈 베이컨의 6단계 법칙
*/


#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int INF = 1e9; // 충분히 큰 값

int main() {
    int N, M;
    cin >> N >> M;
    
    vector<vector<int>> dist(N + 1, vector<int>(N + 1, INF));

    for (int i = 1; i <= N; i++) {
        dist[i][i] = 0;
    }

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        dist[a][b] = 1;
        dist[b][a] = 1;
    }

    for (int k = 1; k <= N; k++) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }

    int minPerson = 1, minSum = INF;
    for (int i = 1; i <= N; i++) {
        int sum = 0;
        for (int j = 1; j <= N; j++) {
            sum += dist[i][j];
        }
        if (sum < minSum) {
            minSum = sum;
            minPerson = i;
        }
    }

    cout << minPerson << endl;
    return 0;
}
