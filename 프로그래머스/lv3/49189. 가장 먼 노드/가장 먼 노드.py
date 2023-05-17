from collections import deque

def solution(n, edge):
    visited = [0]*(n+1)
    adj = [[] for _ in range(n+1)]
    for a,b in edge:
        adj[a].append(b)
        adj[b].append(a)
    
    visited[1] = 1
    q = deque([1])
    
    while q:
        x = q.popleft()
        for next in adj[x]:
            if not visited[next]:
                visited[next] = visited[x] + 1
                q.append(next)
    
    max_v = max(visited)
    cnt = visited.count(max_v)
    
    return cnt if cnt > 0 else 1
