import heapq

def dijkstra(graph, start_node):

    distances = { node: float('inf') for node in graph}
    distances[start_node] = 0

    heap = [(0,start_node)]

    while heap:

        current_distance, current_node = heapq.heappop(heap)

        if current_distance > distances[current_node]:
            continue
        

        for neighbour, weight in graph[current_node]:
            distance = current_distance + weight

            if distance < distances[neighbour]:
                distances[neighbour] = distance
                heapq.heappush(heap, (distance, neighbour))
    
    return distance


graph = {
    'A': [('B', 4), ('C', 2)],
    'B': [('D', 5), ('E', 12)],
    'C': [('E', 10)],
    'D': [('E', 2)],
    'E': []
}

start_node = 'A'
shortest_paths = dijkstra(graph, start_node)
print(shortest_paths)