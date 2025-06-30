const fs = require("fs");
let input = fs.readFileSync("naarang/input.txt").toString().trim().split("\n");

const N = Number(input[0]);
const M = Number(input[1]);

const vip = new Set();
for (let i = 2; i < 2 + M; i++) {
  vip.add(Number(input[i]));
}

const dp = Array.from({ length: N + 1 }, () => [0n, 0n]);

dp[0][0] = 1n;
dp[1][0] = 1n;
if (!vip.has(1) && !vip.has(2)) {
  dp[1][1] = 1n;
}

for (let i = 2; i < N; i++) {
  dp[i][0] = BigInt(dp[i - 1][0]) + BigInt(dp[i - 1][1]); // 교차 안함
  if (!vip.has(i) && !vip.has(i + 1)) {
    dp[i][1] = BigInt(dp[i - 1][0]); // 교차함
  }
}

console.log(String(dp[N - 1][0] + dp[N - 1][1]));

/*

이웃한 두 칸끼리 바꾸거나 안바꾸거나로 경우를 구분 가능
dp[n][0] : n번 자리와 n+1번 자리를 교차하지 않음
dp[n][1] : n번 자리와 n+1번 자리를 교차
-> 교차가 가능한지 살펴볼 때는 n번 자리와 n+1번 자리가 모두 vip가 아님을 확인!


오류) 1 1 1 의 입력이 들어왔을 때 1이라는 답이 나와야하는데 0이라는 값이 나옴
dp[0][0] = 1n;으로 초기화 필요!

*/
