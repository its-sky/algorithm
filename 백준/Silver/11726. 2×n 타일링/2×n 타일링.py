n = int(input())
a = 1
b = 2
if n == 1:
    print(1 % 10007)
elif n == 2:
    print(2 % 10007)
else:
    for i in range(3, n + 1):
        if i % 2 == 0:
            b = a + b
        else:
            a = a + b
    if n % 2 == 0:
        print(b % 10007)
    else:
        print(a % 10007)