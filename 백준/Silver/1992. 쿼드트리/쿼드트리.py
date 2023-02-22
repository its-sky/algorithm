import sys
n = int(sys.stdin.readline())
map = []
for _ in range(n):
    map.append(list(input()))

def merge_sort(s_x, s_y, e_x, e_y):
    if s_x == e_x and s_y == e_y:
        return map[s_y][s_x]
    mid_x = (s_x+e_x) // 2
    mid_y = (s_y+e_y) // 2
    a = merge_sort(s_x,s_y,mid_x,mid_y)
    b = merge_sort(mid_x+1,s_y,e_x,mid_y)
    c = merge_sort(s_x,mid_y+1,mid_x,e_y)
    d = merge_sort(mid_x+1,mid_y+1,e_x,e_y)
    return merge(a, b, c, d)

def merge(a, b, c, d):
    if a == b == c == d and len(a) == 1:
        return a
    else:
        return "("+a+b+c+d+")"

st = merge_sort(0,0,n-1,n-1)
print(st)