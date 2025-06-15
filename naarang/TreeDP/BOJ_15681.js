const fs = require("fs");
let input = fs.readFileSync("naarang/input.txt").toString().trim().split("\n");

const [N, R, Q] = input[0].split(" ").map(Number);
const subtreeSize = new Array(N + 1).fill(0);
const visited = new Array(N + 1).fill(false);

const tree = {};
for (let i = 1; i <= N - 1; i++) {
  let [u, v] = input[i].split(" ").map(Number);

  if (!tree[u]) tree[u] = [];
  tree[u].push(v);
  if (!tree[v]) tree[v] = [];
  tree[v].push(u);
}

// DFS로 서브트리 크기 한번에 계산
const dfs = (node) => {
  visited[node] = true;
  subtreeSize[node] = 1; // 자기 자신 계산

  for (let nextNode of tree[node] ?? []) {
    if (visited[nextNode] === false) {
      visited[nextNode] = true;
      dfs(nextNode);
      subtreeSize[node] += subtreeSize[nextNode]; // 후처리(post-order)로 부모에 카운팅 반영
    }
  }
};

dfs(R);

let answer = [];
for (let i = N; i < N + Q; i++) {
  let u = Number(input[i]);
  answer.push(subtreeSize[u]);
}

console.log(answer.join("\n"));

// 1 ≤ Q ≤ 10^5 이므로 각 노드의 서브쿼리의 개수를 미리 저장해야 함! (dp)
/*
DFS의 경우 서브쿼리의 개수를 구해야하기 때문에 반복문보다 재귀가 훨씬 더 간편함
후처리(post-order) 가 자연스럽게 구현됨
→ 재귀는 함수 호출이 끝난 후(=자식들을 모두 처리한 후) 부모로 돌아오기 때문에,
→ 바로 그 시점에 서브트리 크기를 계산하기 딱 좋습니다.

*/
