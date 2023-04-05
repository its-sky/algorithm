from collections import deque

def BFS(maps, visited, x_size, y_size, now_x, now_y, target):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    q = deque()
    q.append([now_x, now_y])
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            vx = x + dx[i]
            vy = y + dy[i]
            if 0<=vx<x_size and 0<=vy<y_size:
                if visited[vx][vy] == 0 and maps[vx][vy] != target and maps[vx][vy] != 'X':
                    visited[vx][vy] = visited[x][y] + 1
                    q.append([vx, vy])
                elif maps[vx][vy] == target:
                    visited[vx][vy] = visited[x][y] + 1
                    return [vx, vy, visited[vx][vy]]
    return [-1, -1, -1]

def solution(maps):
    res = 0
    x_size = len(maps)
    y_size = len(maps[0])
    visited = [[0]*y_size for _ in range(x_size)]
    now_x = 0
    now_y = 0
    for i in range(x_size):
        for j in range(y_size):
            if maps[i][j] == 'S':
                now_x = i
                now_y = j
                break
    tmp = BFS(maps, visited, x_size, y_size, now_x, now_y, 'L')
    print(visited)
    if tmp[0] == -1:
        return -1
    visited = [[0]*y_size for _ in range(x_size)]
    visited[tmp[0]][tmp[1]] = tmp[2]
    # print(now_x, now_y)
    tmp = BFS(maps, visited, x_size, y_size, tmp[0], tmp[1], 'E')
    print(visited)
    if tmp[0] == -1:
        return -1
    return tmp[2]