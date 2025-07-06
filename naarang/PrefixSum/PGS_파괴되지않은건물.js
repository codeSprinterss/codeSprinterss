function solution(board, skill) {
  var answer = 0;

  const n = board.length;
  const m = board[0].length;

  const sum = Array.from({ length: n + 1 }, () => Array(m + 1).fill(0));

  for (let [type, r1, c1, r2, c2, degree] of skill) {
    const effect = type === 1 ? -degree : degree;

    sum[r1][c1] += effect;
    sum[r1][c2 + 1] -= effect;
    sum[r2 + 1][c1] -= effect;
    sum[r2 + 1][c2 + 1] += effect;
  }

  // 행 누적함
  for (let i = 0; i < n; i++) {
    for (let j = 1; j < m; j++) {
      sum[i][j] += sum[i][j - 1];
    }
  }

  // 열 누적합
  for (let j = 0; j < m; j++) {
    for (let i = 1; i < n; i++) {
      sum[i][j] += sum[i - 1][j];
    }
  }

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (board[i][j] + sum[i][j] >= 1) answer++;
    }
  }

  return answer;
}

/*
2중 for문으로 매번 board에 갱신하면 시간 초과

2차원 배열 누적합으로 계산 필요

(r1, c1) → 시작점에 +degree
(r1, c2+1) → 오른쪽으로 넘어가지 못하도록 -degree
(r2+1, c1) → 아래로 내려가지 못하도록 -degree
(r2+1, c2+1) → 위 두 번 빼버린 corner 영역 복구 +degree

이후에 네 귀퉁이에 찍은 값들을 반영하기 위해 행 누적합 -> 열 누적합으로 퍼뜨려야 함!

*/
