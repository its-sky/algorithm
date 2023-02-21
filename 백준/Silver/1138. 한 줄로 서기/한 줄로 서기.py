n = int(input())
count = list(map(int, input().split()))
num = [i for i in range(1, n+1)]
line = []

for i in range(n):
    for j in range(len(count)):
        cnt = 0
        for k in range(len(line)):
            if line[k] > num[j]:
                cnt += 1
        if cnt == count[j]:
            line.append(num[j])
            num.remove(num[count.index(cnt)])
            count.remove(cnt)
            break
print(*line)