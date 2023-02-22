import sys
n = int(sys.stdin.readline())
li = list(map(int, sys.stdin.readline().split()))
dp = [0]*n
dp[0] = li[0]
for i in range(1, n):
    target = li[i]
    for j in range(i):
        if target < dp[j] + li[i-j-1]:
            target = dp[j]+li[i-j-1]
    dp[i] = target
print(dp[n-1])