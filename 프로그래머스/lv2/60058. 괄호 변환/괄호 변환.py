def alg(w):
    tmp = ""
    if w == "":
        return ""
    f = find_first(w)
    u = w[:f+1]
    v = w[f+1:]
    if (right(u)):
        return u + alg(v)
    else:
        tmp += "("
        tmp += alg(v) + ")"
        size = len(u)
        if size > 2:
            for i in range(1, size - 1):
                if u[i] == '(':
                    tmp += ")"
                else:
                    tmp += "("
        return tmp
    
def right(st):
    i = 0
    tmp = 0
    for i in range(len(st)):
        if st[i] == '(':
            tmp += 1
        else:
            tmp -= 1
        
        if tmp < 0:
            return False
    return True

def find_first(st):
    i = 0
    tmp = 0
    for i in range(len(st)):
        if i != 0 and tmp == 0:
            return i - 1
        if st[i] == '(':
            tmp += 1
        else:
            tmp -= 1
    return i
def solution(p):
    answer = ''

    if right(p):
        return p
    else:
        return alg(p)
        