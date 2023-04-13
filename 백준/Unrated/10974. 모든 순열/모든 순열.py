from itertools import permutations

n = int(input())
li = [i+1 for i in range(n)]
per = list(permutations(li, n))
for p in per:
    print(*p)