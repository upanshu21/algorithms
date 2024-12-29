// package main

// import "fmt"

// type Edge struct {
// 	weight int32
// 	node string
// 	prev string
// }

// func main() {
// 	graph := map[string][]Edge{
// 		"A": {{weight: 2, node: "B"}, {weight: 3, node: "C"}},
// 		"B": {{weight: 2, node: "A"}, {weight: 1, node: "C"}, {weight: 4, node: "D"}},
// 		"C": {{weight: 3, node: "A"}, {weight: 1, node: "B"}, {weight: 5, node: "D"}},
// 		"D": {{weight: 4, node: "B"}, {weight: 5, node: "C"}},
// 	}

// 	startNode := "A"
// 	mst, cost := primsAlgorithm(graph, startNode)

// 	fmt.Println("Edges in MST:")
// 	for _, edge := range mst {
// 		fmt.Printf("%s - %s (Weight: %d)\n", edge.prev, edge.node, edge.weight)
// 	}

// 	fmt.Printf("Total cost of MST: %d\n", cost)
// }