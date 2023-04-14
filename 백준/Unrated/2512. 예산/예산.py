import sys
input = sys.stdin.readline

n = int(input())
li = list(map(int, input().split()))
cost = int(input())
right = max(li)
left = 0
res = 0
res_mid = 0

def check(li, cost, compare):
  tmp = 0
  for i in range(n):
      if li[i] >= compare:
          tmp += compare
      if li[i] < compare:
          tmp += li[i]
  if tmp <= cost:
      return tmp
  return 0

while left <= right:
    mid = (left + right) // 2
    tmp = check(li, cost, mid)
    if tmp == 0:
        right = mid - 1
    else:
        if res < tmp:
            res = tmp
            res_mid = mid
        left = mid + 1
print(res_mid) 