function solution(info, edges) {
  let answer = 0;
  const graph = {};

  for (const [parent, child] of edges) {
    if (!graph[parent]) graph[parent] = [];
    graph[parent].push(child);
  }

  function dfs(node, sheepNum, wolfNum, queue) {
    answer = Math.max(sheepNum, answer);

    const children = graph[node] ?? [];
    const nextQueue = [...children, ...queue];

    for (const child of nextQueue) {
      if (info[child] === 1) {
        // 늑대
        if (sheepNum <= wolfNum + 1) continue; // 잡아먹히는 경우

        dfs(
          child,
          sheepNum,
          wolfNum + 1,
          nextQueue.filter((next) => next !== child)
        );
      } else {
        // 양
        dfs(
          child,
          sheepNum + 1,
          wolfNum,
          nextQueue.filter((next) => next !== child)
        );
      }
    }
  }

  dfs(0, 1, 0, []);

  return answer;
}
