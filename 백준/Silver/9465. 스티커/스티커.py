import sys

case = int(sys.stdin.readline())

for i in range(case):
    li = []
    n = int(sys.stdin.readline())
    value = [[0]*n for _ in range(2)]
    for _ in range(2):
        li.append(list(map(int, sys.stdin.readline().split())))
    value[0][0] = li[0][0]
    value[1][0] = li[1][0]
    for j in range(1, n):
        value[0][j] = max(value[0][j-1]-li[0][j-1]+li[0][j], value[1][j-1]+li[0][j])
        value[1][j] = max(value[1][j-1]-li[1][j-1]+li[1][j], value[0][j-1]+li[1][j])
    print(value[0][n-1] if value[0][n-1] > value[1][n-1] else value[1][n-1])