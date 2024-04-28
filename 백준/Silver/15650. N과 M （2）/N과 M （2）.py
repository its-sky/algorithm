from itertools import combinations

n, m = map(int, input().split())
li = [i+1 for i in range(n)]
combi = combinations(li, m)
for com in combi:
    print(*com)