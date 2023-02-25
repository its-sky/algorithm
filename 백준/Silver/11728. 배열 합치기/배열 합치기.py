n, m = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
res = A+B
print(*sorted(res))