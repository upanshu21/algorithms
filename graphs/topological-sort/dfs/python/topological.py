from collections import deque, defaultdict


def topological_sort(vertices, edges):

    adj = {i:[] for i in range(vertices)}
    for i,j in edges:
        adj[i].append(j)
    
    stack = []
    visited = set()

    def dfs(node):

        visited.add(node)

        for n in adj[node]:
            if n not in visited:
                dfs(n)
        
        stack.append(node)
    
    for vertex in range(vertices):
        if vertex not in visited:
            dfs(vertex)
    
    return stack[::-1]



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