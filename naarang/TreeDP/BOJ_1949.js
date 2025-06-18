const fs = require("fs");
let input = fs.readFileSync("naarang/input.txt").toString().trim().split("\n");

const N = Number(input[0]);
let people = [0, ...input[1].split(" ").map(Number)]; // 이렇게 하면 1번 마을을 1 index를 가지도록 설정 가능!
const tree = {};

for (let i = 2; i < 2 + N - 1; i++) {
  const [a, b] = input[i].split(" ").map(Number);

  if (!tree[a]) tree[a] = [];
  tree[a].push(b);
  if (!tree[b]) tree[b] = [];
  tree[b].push(a);
}

const visited = new Array(N + 1).fill(false);
const dp = Array.from({ length: N + 1 }, () => [0, 0]);

const dfs = (node) => {
  visited[node] = true;
  dp[node][0] = 0;
  dp[node][1] = people[node];

  for (let nextNode of tree[node] ?? []) {
    if (!visited[nextNode]) {
      dfs(nextNode);
      // 후처리(post-order)로 상위 부모 노드에 반영
      dp[node][0] += Math.max(dp[nextNode][0], dp[nextNode][1]);
      dp[node][1] += dp[nextNode][0]; // 이미 선택했으므로 인접한 마을 선택 불가능
    }
  }
};

dfs(1); // 임의로 루트노드를 1로 둠
console.log(Math.max(dp[1][0], dp[1][1]));

/*
dp로 선택함 or 안 함을 계산
dp[node][0]: node가 우수 마을이 아닌 경우의 최대 주민 수
dp[node][1]: node가 우수 마을인 경우의 최대 주민 수

무방향그래프이므로 임의로 루트를 정하는 것이 편하다!
-> 트리에서 각 노드를 루트로 하는 서브트리에 대해 최적해를 계산

*/
