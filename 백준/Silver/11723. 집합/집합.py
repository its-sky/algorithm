import sys
input = sys.stdin.readline

s = set([])
n = int(input())
for i in range(n):
    li = input().split()
    op = li[0]
    if len(li) == 2:
        num = int(li[1])
    if op == "add":
        s.add(num)
    elif op == "remove":
        if num in s:
            s.remove(num)
    elif op == "check":
        if num in s:
            print(1)
        else:
            print(0)
    elif op == "toggle":
        if num in s:
            s.remove(num)
        else:
            s.add(num)
    elif op == "all":
        s = set([i+1 for i in range(20)])
    elif op == "empty":
        s = set([])