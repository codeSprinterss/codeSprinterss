const fs = require("fs");
let input = fs.readFileSync("naarang/input.txt").toString().trim().split("\n");

const N = Number(input[0]);

const lines = [];

for (let i = 1; i <= N; i++) {
  const [start, end] = input[i].split(" ").map(Number);
  lines.push([start, end]);
}

// 전기줄의 시작점-종료점 중에서 시작점을 기준으로 오름차순 정렬
lines.sort((a, b) => a[0] - b[0]);

const lis = [lines[0][1]];

const binarySearch = (target) => {
  let start = 0;
  let end = lis.length - 1;

  while (start < end) {
    let mid = Math.floor((start + end) / 2);

    if (lis[mid] >= target) {
      end = mid;
    } else {
      start = mid + 1;
    }
  }

  return start;
};

for (let i = 1; i < N; i++) {
  target = lines[i][1];

  if (lis[lis.length - 1] < target) {
    lis.push(target);
  } else {
    const index = binarySearch(target);
    lis[index] = target;
  }
}

console.log(N - lis.length);

/*
각 전기줄마다 교차되는 전기줄을 저장하고 교차되는 것이 많은 순으로 제거하면 되지 않나? 라고 처음에 생각했는데 이 문제는 LIS를 떠올리는 것이 핵심이었다!

"A와 B가 모두 증가하는 형태면 교차가 만들어지지 않음!" -> 교차가 만들어지지 않는 최대 증가수열을 구하자 -> 전체 전깃줄 개수 - LIS 길이 = 제거할 전깃줄 수

O(NlogN)을 가지는 이분탐색을 이용한 LIS로 구현
*/
