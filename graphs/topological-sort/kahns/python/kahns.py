from collections import deque

def topological_sort(vertices, edges):
    result = []
    indegree = [0] * vertices
    adj = {i:[] for i in range(vertices)}

    for i,j in edges:
        adj[i].append(j)
        indegree[j]+=1

    queue = deque([i for i in range(len(indegree)) if indegree[i] == 0])
    
    while queue:
        curr = queue.popleft()
        result.append(curr)

        for i in adj[curr]:
            indegree[i] -=1
            if indegree[i] == 0:
                queue.append(i) 
    return result


if __name__ == "__main__":
    vertices = 6
    edges = [
        (5, 2),
        (5, 0),
        (4, 0),
        (4, 1),
        (2, 3),
        (3, 1)
    ]

    try:
        result = topological_sort(vertices, edges)
        print("Topological Sort:", result)
    except ValueError as e:
        print(e)