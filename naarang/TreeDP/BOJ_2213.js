const fs = require("fs");
let input = fs.readFileSync("naarang/input.txt").toString().trim().split("\n");

const N = Number(input[0]);
const weights = [0, ...input[1].split(" ").map(Number)]; // 이렇게 하면 1번 정점 가중치를 1 index를 가지도록 설정 가능!
const tree = {};

for (let i = 2; i < 2 + N - 1; i++) {
  const [a, b] = input[i].split(" ").map(Number);

  if (!tree[a]) tree[a] = [];
  tree[a].push(b);
  if (!tree[b]) tree[b] = [];
  tree[b].push(a);
}

const visited = new Array(N + 1).fill(false);
const dp = Array.from({ length: N + 1 }, () => [
  0, // dp[node][0]: node를 선택 안 했을 때 최대 가중치 합
  [], // dp[node][1]: 그때의 노드 리스트

  0, // dp[node][2]: node를 선택했을 때 최대 가중치 합
  [], // dp[node][3]: 그때의 노드 리스트
]);

const dfs = (node, parent) => {
  dp[node][2] = weights[node]; // node를 선택한 경우
  dp[node][3] = [node]; // 선택한 노드에 자기 자신 추가

  for (let child of tree[node] ?? []) {
    if (child === parent) continue;

    dfs(child, node);

    // node를 선택하지 않은 경우: 자식은 선택하거나 안 하거나 더 큰 쪽 선택
    if (dp[child][0] > dp[child][2]) {
      dp[node][0] += dp[child][0];
      dp[node][1] = dp[node][1].concat(dp[child][1]);
    } else {
      dp[node][0] += dp[child][2];
      dp[node][1] = dp[node][1].concat(dp[child][3]);
    }

    // node를 선택한 경우: 자식은 무조건 선택 불가
    dp[node][2] += dp[child][0];
    dp[node][3] = dp[node][3].concat(dp[child][1]);
  }
};

dfs(1); // 임의의 루트 노드를 1로

if (dp[1][0] > dp[1][2]) {
  console.log(dp[1][0]);
  console.log(dp[1][1].sort((a, b) => a - b).join(" "));
} else {
  console.log(dp[1][2]);
  console.log(dp[1][3].sort((a, b) => a - b).join(" "));
}

// 1949번 유형에서 경로까지 파악하는 문제!
