import heapq

def prims_algorithm(graph, start_node):

    # the adjacency list is already provided for this in main function.

    mst = []
    visited = set()
    cost = 0

    heap = [(0, start_node, None)]

    while heap:
        # [0, 'A', None]
        weight, current_node, previous_node = heapq.heappop(heap)

        if current_node in visited:
            continue
            
        visited.add(current_node)
        if previous_node is not None:
            mst.append((previous_node, current_node, weight))
        
        cost += weight

        for neighbour, n_wight in graph[current_node]:
            if neighbour not in visited:
                heapq.heappush(heap, (n_wight, neighbour, current_node))

    return mst, cost



if __name__ == "__main__":

    graph = {
        'A': [('B', 2), ('C', 3)],
        'B': [('A', 2), ('C', 1), ('D', 4)],
        'C': [('A', 3), ('B', 1), ('D', 5)],
        'D': [('B', 4), ('C', 5)],
    }

    start_node = 'A'
    mst, cost = prims_algorithm(graph, start_node)

    print("Edges in MST:")
    for edge in mst:
        print(f"{edge[0]} - {edge[1]} (Weight: {edge[2]})")

    print(f"Total cost of MST: {cost}") 
