import heapq
import sys
input = sys.stdin.readline
n = int(input())
time = []
for i in range(n):
    time.append(tuple(map(int, input().split())))
time.sort(key=lambda x:(x[0], x[1]))

room = []
heapq.heappush(room, time[0][1])

for i in range(1, n):
    if time[i][0] < room[0]:
        heapq.heappush(room, time[i][1])
    else:
        heapq.heappop(room)
        heapq.heappush(room, time[i][1])
        
print(len(room))