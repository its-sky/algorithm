import sys

n = int(input())
li = list(map(int, sys.stdin.readline().split()))
li.sort()
tmp = 0
answer = 0
for i in range(len(li)):
    tmp += li[i]
    answer += tmp
print(answer)