def DnC(s_x, s_y, e_x, e_y, arr):
    tmp = ""
    if s_x + 1 == e_x and s_y + 1 == e_y:
        cnt = 0
        for i in range(s_y, s_y+2):
            for j in range(s_x, s_x+2):
                tmp += str(arr[i][j])
                cnt += arr[i][j]
        if cnt == 4:
            return "1"
        elif cnt == 0:
            return "0"
        else:
            return tmp
    else:
        tmp += DnC(s_x, s_y, s_x+(e_x-s_x)//2, s_y+(e_y-s_y)//2, arr)
        tmp += DnC(s_x+(e_x-s_x)//2+1, s_y, e_x, s_y+(e_y-s_y)//2, arr)
        tmp += DnC(s_x,s_y+(e_y-s_y)//2+1,s_x+(e_x-s_x)//2,e_y, arr)
        tmp += DnC(s_x+(e_x-s_x)//2+1, s_y+(e_y-s_y)//2+1, e_x, e_y, arr)
        if len(tmp) == 4 and tmp[0] == tmp[1] == tmp[2] == tmp[3]:
            return tmp[0]
        else:
            return tmp
def solution(arr):
    size = len(arr[0])
    answer = DnC(0, 0, size-1, size-1, arr)
    cnt1 = 0
    cnt2 = 0
    for i in range(len(answer)):
        if answer[i] == "0":
            cnt1 += 1
        else:
            cnt2 += 1
    return [cnt1, cnt2]
