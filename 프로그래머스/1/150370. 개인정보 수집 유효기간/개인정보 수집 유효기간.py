from collections import defaultdict

def solution(today, terms, privacies):
    sign = defaultdict()
    res = []
    
    for term in terms:
        inputs = term.split(" ")
        sign[inputs[0]] = int(inputs[1])*28
    
    year = int(today.split(".")[0])*336
    mon = int(today.split(".")[1])*28
    day = int(today.split(".")[2])
    
    day = year + mon + day
    
    for i in range(len(privacies)):
        tmp = privacies[i].split(" ")[0]
        term = privacies[i].split(" ")[1]
        count = int(tmp.split(".")[0])*336+int(tmp.split(".")[1])*28+int(tmp.split(".")[2]) + sign[term]
        if (count <= day): res.append(i + 1)
    
    return res