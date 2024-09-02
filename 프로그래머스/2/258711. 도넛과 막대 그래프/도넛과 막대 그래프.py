def solution(edges):
    def count_edges(edges):
        edge_counts = {}
        for a, b in edges:
            if not edge_counts.get(a):
                edge_counts[a] = [0, 0]
            if not edge_counts.get(b):
                edge_counts[b] = [0, 0]
            
            edge_counts[a][0] += 1
            edge_counts[b][1] += 1
        return edge_counts

    def check_answer(edge_counts):
        answer = [0, 0, 0, 0]
        for key, counts in edge_counts.items():
            if counts[0] >= 2 and counts[1] == 0:
                answer[0] = key
            elif counts[0] == 0 and counts[1] > 0:
                answer[2] += 1
            elif counts[0] >= 2 and counts[1] >= 2:
                answer[3] += 1
        answer[1] = (edge_counts[answer[0]][0] - answer[2] - answer[3])
        
        return answer

    edge_counts = count_edges(edges)
    answer = check_answer(edge_counts)
    return answer