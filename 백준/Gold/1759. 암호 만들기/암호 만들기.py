from itertools import combinations

L,C = map(int, input().split())
alpha = list(input().split())
a = []
b = []
words = []
tmp = 1

for item in alpha:
    if item == 'a' or item == 'e' or item == 'i' or item == 'o' or item == 'u':
        a.append(item)
    else:
        b.append(item)

for i in range(1, min(L-2, len(a)) + 1):
    a_com = list(combinations(a, i))
    for j in range(2, min(L-i+1,len(b))+1):
        if i + j == L:
            b_com = list(combinations(b, j))
            for item1 in a_com:
                for item2 in b_com:
                    t_res = sorted(list(item1+item2))
                    st = ''.join(t_res)
                    if st not in words:
                        words.append(st)
words.sort()
for item in words:
  print(item)