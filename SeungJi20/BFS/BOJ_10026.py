from collections import deque

n = int(input())
graph = [list(input()) for _ in range(n)]

# 방향
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# BFS
def bfs(x, y, visited, graph):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    current_color = graph[x][y]

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if graph[nx][ny] == current_color:
                    visited[nx][ny] = True
                    q.append((nx, ny))

# 일반인 구역 개수
visited_normal = [[False] * n for _ in range(n)]
count_normal = 0
for i in range(n):
    for j in range(n):
        if not visited_normal[i][j]:
            bfs(i, j, visited_normal, graph)
            count_normal += 1

# 적록색약 : R을 G로 바꿔줌
color_blind_graph = [['G' if color == 'R' else color for color in row] for row in graph]

# 적록색약 구역 개수
visited_cb = [[False] * n for _ in range(n)]
count_cb = 0
for i in range(n):
    for j in range(n):
        if not visited_cb[i][j]:
            bfs(i, j, visited_cb, color_blind_graph)
            count_cb += 1

print(count_normal, count_cb)