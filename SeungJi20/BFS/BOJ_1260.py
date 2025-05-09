from collections import deque

# 한 줄에 입력받기!!
N, M, V = map(int, input().split())

graph = [[] for _ in range(N+1)] # 그래프 초기화

for _ in range(M): # 연결 정보
    a, b =map(int, input().split())
    graph[a].append(b)
    graph[b].append(a) # 양방향
    
visited = [False] * (N+1)

# 정점 번호가 작은 것부터 방문하도록 정렬
for i in range(1, N + 1):
    graph[i].sort()

# DFS(재귀)
def dfs_recursive(v, visited, result):
    visited[v] = True
    result.append(v)
    for i in graph[v]:
        if not visited[i]:
            dfs_recursive(i, visited, result)

# BFS
def bfs(start):
    visited = [False] * (N + 1)
    queue = deque([start])
    result = []
    visited[start] = True

    while queue:
        v = queue.popleft()
        result.append(v)
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
    return result

# 실행
visited_dfs = [False] * (N + 1)
result_dfs = []
dfs_recursive(V, visited_dfs, result_dfs)

result_bfs = bfs(V)

print(*result_dfs)
print(*result_bfs)