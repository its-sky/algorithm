front = list(input())
rear = list(reversed(front))
size = len(front)
cnt = 0

for i in range(size):
    cnt = 0
    j = 0
    while i+j < size and front[i+j] == rear[j]:
        cnt += 1
        j += 1
    if cnt != 0 and size - i == cnt:
        break
print(2*size - cnt)