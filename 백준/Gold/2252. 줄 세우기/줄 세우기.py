import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
arr = []
inDegree = [0 for _ in range(32001)]
graph = [[] for _ in range(32001)]
q = deque()

for i in range(m):
    a, b = map(int, input().split())
    arr.append([a, b])

for a, b in arr:
    inDegree[b] += 1
    graph[a].append(b)

for i in range(1, n + 1):
    if inDegree[i] == 0:
        q.append(i)
while q:
    item = q.popleft()
    for i in graph[item]:
        inDegree[i] -= 1
        if inDegree[i] == 0:
            q.append(i)
    print(item, end=' ')