def solution(cap, n, deliveries, pickups):
    d_val, p_val = 0, 0
    answer = 0
    for i in range(n):
        d_val += deliveries[n-i-1]
        p_val += pickups[n-i-1]
        while p_val > 0 or d_val > 0:
            d_val -= cap
            p_val -= cap
            answer += 2*(n-i)
    return answer