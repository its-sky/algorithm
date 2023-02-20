n, k, l = map(int, input().split())
if k > l:
    k, l = l, k
cnt = 0
    
while True:
    cnt += 1
    if k + 1 == l and l % 2 == 0:
        break
    if k % 2 == 0:
        k = k // 2
    else:
        k = k // 2 + 1
    if l % 2 == 0:
        l = l // 2
    else:
        l = l // 2 + 1
print(cnt)