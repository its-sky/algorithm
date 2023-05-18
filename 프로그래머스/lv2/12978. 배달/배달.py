def solution(N, road, K):
    INF = int(1e9)
    matrix = [[INF]*N for _ in range(N)]

    for i in range(N):
        matrix[i][i] = 0
    
    for a, b, cost in road:
        matrix[a-1][b-1] = min(matrix[a-1][b-1], cost)
        matrix[b-1][a-1] = min(matrix[b-1][a-1], cost)
    
    for k in range(N):
        for i in range(N):
            for j in range(N):
                matrix[i][j] = min(matrix[i][j], matrix[i][k] + matrix[k][j])
    
    ans = [x for x in matrix[0] if x <= K]
    
    return len(ans)