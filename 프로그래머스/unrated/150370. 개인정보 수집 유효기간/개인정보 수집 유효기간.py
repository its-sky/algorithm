def solution(today, terms, privacies):
    answer = []
    valid = [0] * 26
    
    for term in terms:
        a, t = term.split(" ")
        valid[ord(a)-ord('A')] = int(t)
    t_y, t_m, t_d = today.split(".")
    t_y = int(t_y)
    t_m = int(t_m)
    t_d = int(t_d)
    t_total = 336*t_y + 28*t_m + t_d
    for i, privacy in enumerate(privacies):
        day, alpha = privacy.split(" ")
        y, m, d = day.split(".")
        y = int(y)
        m = int(m)
        d = int(d)
        if d == 1:
            d = 28
            m += valid[ord(alpha) - ord('A')] - 1
        else:
            d -= 1
            m += valid[ord(alpha) - ord('A')]
        if (m > 12):
            m -= 12
            y += 1
        total = 336*y+28*m+d
        if t_total > total:
            answer.append(i+1)
    return answer