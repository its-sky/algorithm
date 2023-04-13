def solution(lottos, win_nums):
    valid = []
    for lotto in lottos:
        if lotto == 0:
            valid.append(-1)
        elif lotto in win_nums:
            valid.append(1)
        else:
            valid.append(0)
    cnt_zero = valid.count(-1)
    total = sum(valid)
    if total == 0 and cnt_zero == 0:
        return [6, 6]
    else:
        return [(7-(total+2*cnt_zero)), (7-(total+cnt_zero))] if cnt_zero < 6 else [1, 6]
    
    
    