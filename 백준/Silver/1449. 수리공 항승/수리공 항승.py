import sys
input = sys.stdin.readline

N, L = map(int, input().split())
point = list(map(int, input().split()))
point.sort()
cnt = 0
curr = 0
while curr != N:
    target = point[curr]
    while curr < N and point[curr] <= target+L-0.5:
        curr += 1
    cnt += 1
print(cnt)