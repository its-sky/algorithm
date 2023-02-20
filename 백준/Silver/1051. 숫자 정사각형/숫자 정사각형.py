n, m = map(int, input().split())
li = []
ans = [0]
for _ in range(n):
    li.append(input())
    
for i in range(n-1):
    for j in range(i+1, n):
        for k in range(m-j+i):
            if li[i][k] == li[j][k] == li[i][k+j-i] == li[j][k+j-i]:
                ans.append(j-i)
size = max(ans)
size = (size+1)**2
print(size)