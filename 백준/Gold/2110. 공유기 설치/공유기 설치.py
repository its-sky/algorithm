import sys
input = sys.stdin.readline
n, c = map(int, input().split())

li = []
for i in range(n):
    li.append(int(input()))
    
li.sort()

def binary_search(li, start, end):
    while start <= end:
        mid = (start + end) // 2
        curr = li[0]
        count = 1
        
        for i in range(1, len(li)):
            if li[i] >= curr + mid:
                count += 1
                curr = li[i]
        if count >= c:
            global answer
            start = mid + 1
            answer = mid
        else:
            end = mid - 1
            
start = 1
end = li[-1] - li[0]
answer = 0

binary_search(li, start, end)
print(answer)