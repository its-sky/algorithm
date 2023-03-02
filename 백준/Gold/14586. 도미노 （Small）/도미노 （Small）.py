import sys

INF = sys.maxsize
n = int(input())
domino = [
    tuple(map(int, input().split()))
    for _ in range(n)
]
domino.sort()

# left[i] -> i번째 도미노를 왼쪽으로 넘어뜨렸을 때 마지막으로 넘어지는 도미노의 index
left = [i for i in range(n)]
# right[i] -> i번째 도미노를 오른쪽으로 넘어뜨렸을 때 마지막으로 넘어지는 도미노의 index
right = [i for i in range(n)]

for i in range(n):
    start_point, height = domino[i]
    left_end_point = start_point - height
    right_end_point = start_point + height
    for j in range(i, -1, -1):
        if left_end_point <= domino[j][0]:
            left_end_point = min(left_end_point, domino[j][0] - domino[j][1])
            left[i] = min(left[i], j)
    for j in range(i + 1, n):
        if right_end_point >= domino[j][0]:
            right_end_point = max(right_end_point, domino[j][0] + domino[j][1])
            right[i] = max(right[i], j)

# dp[i] -> 0 ~ i까지 넘어뜨리는 데 필요한 최소 횟수
dp = [INF for i in range(n)]
# 0~0번째 도미노를 넘어뜨리는 데 필요한 최소 개수는 1개 
dp[0] = 1

for i in range(n):
    if left[i] - 1 < 0:
        dp[i] = min(dp[i], 1)
    else:
        # i번째 도미노를 왼쪽으로 무너뜨렸을 때 left[i]번째까지 한방에 무너지므로, 
        # 0 ~ i번째 도미노까지 무너뜨리는 데 필요한 최소 횟수는 0 ~ left[i] - 1까지 넘어뜨리는 데 필요한 최소 횟수 + 1
        dp[i] = min(dp[i], dp[left[i] - 1] + 1)

    # 왼쪽으로 넘어뜨렸을 때의 최솟값을 전부 고려했다면 이번에는 오른쪽으로 넘어뜨렸을 때의 상황을 고려해야함
    # 만약 i보다 왼쪽에 있는 j번째 도미노를 오른쪽으로 넘어뜨렸을 때, i번째 도미노가 같이 넘어진다면, dp[i] = min(dp[i], dp[j - 1] + 1)로 볼 수 있음 
    # 이는 앞서 i보다 왼쪽에 있는 dp들이 모두 제대로 업데이트 됐기 때문에 가능한 검증임
    for j in range(i):
        if right[j] >= i:
            if j == 0:
                dp[i] = min(dp[i], 1)
            else:
                dp[i] = min(dp[i], dp[j - 1] + 1) 

print(dp[n - 1])