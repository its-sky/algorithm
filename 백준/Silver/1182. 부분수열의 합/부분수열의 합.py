from itertools import combinations

N, S = map(int, input().split())
li = list(map(int, input().split()))
cnt = 0

for i in range(1, N+1):
    com = combinations(li, i)
    for item in com:
        if sum(item) == S:
            cnt += 1
print(cnt)