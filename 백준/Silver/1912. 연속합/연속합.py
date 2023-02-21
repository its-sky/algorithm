import sys

n = int(sys.stdin.readline())
li = list(map(int, sys.stdin.readline().split()))
plus = [0]*n
plus[0] = li[0]
for i in range(1, n):
    plus[i] = max(li[i], plus[i-1]+li[i])
print(max(plus))