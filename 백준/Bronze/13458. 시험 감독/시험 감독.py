n = int(input())
ppl = list(map(int, input().split()))
b, c = map(int, input().split())
res = 0

for i in range(n):
    tmp = ppl[i]
    tmp = tmp - b
    res += 1
    if tmp <= 0:
        continue
    cnt = tmp // c
    tmp = tmp % c
    if tmp > 0:
        cnt += 1
    res += cnt
print(res)