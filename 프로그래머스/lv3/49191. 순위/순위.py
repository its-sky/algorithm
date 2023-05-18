def solution(n, results):
    matrix = [[None]*n for _ in range(n)]
    for win, lose in results:
        matrix[win-1][lose-1] = True
        matrix[lose-1][win-1] = False
        
    for i in range(n):
        for j in range(n):
            for k in range(n):
                if matrix[j][i] == None:
                    continue
                
                if matrix[j][i] == matrix[i][k]:
                    matrix[j][k] = matrix[j][i]
                    matrix[k][j] = not matrix[j][i]
                    
    answer = 0
    for i in range(n):
        if None in matrix[i][:i] + matrix[i][i+1:]:
            continue
        answer += 1
    return answer

# 4 3 2
# 3 2
# 1 2
# 2 5

# 누가 완전히 경기 결과가 다 나왔을때 이 사람한테 진 사람은 결과가 이미 나온 것임