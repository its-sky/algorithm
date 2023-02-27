import sys
input = sys.stdin.readline
sq = []
graph = [[0]*101 for _ in range(101)]

n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    for i in range(y, y+10):
        for j in range(x, x+10):
            if graph[i][j] == 0:
                graph[i][j] = 1
print(sum(map(sum, graph)))