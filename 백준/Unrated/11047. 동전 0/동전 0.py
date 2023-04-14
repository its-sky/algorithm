import sys
input = sys.stdin.readline
N, K = map(int, input().split())
li = [0]*N

for i in range(N):
    li[i] = int(input())

cnt = 0
for i in reversed(range(N)):
    cnt += K//li[i]
    K = K%li[i]
print(cnt)