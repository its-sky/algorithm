from itertools import permutations

n, m = map(int, input().split())

li = [i+1 for i in range(n)]
per = list(permutations(li, m))
for p in per:
    print(*p)