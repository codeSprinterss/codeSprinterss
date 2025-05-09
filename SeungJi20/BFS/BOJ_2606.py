from collections import deque
n = int(input()) # 컴퓨터 수
m = int(input()) # 연결쌍 수

graph = [[] for _ in range(n+1)] # 그래프 초기화

for _ in range(m): # 연결된 노드 정보
    a, b =map(int, input().split())
    graph[a].append(b)
    graph[b].append(a) # 양방향
    
visited = [False] * (n+1)

def bfs(start):
    queue = deque([start])
    visited[start] = True
    count = 0
    
    while queue:  # bfs
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                count += 1
    return count
print(bfs(1))