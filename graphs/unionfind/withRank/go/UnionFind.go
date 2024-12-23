package main

import "fmt"

type UnionFind struct {
	parent []int
	rank   []int
}

func NewUnionFind(n int) *UnionFind {
	uf := &UnionFind{
		parent: make([]int, n),
		rank:   make([]int, n),
	}

	for i := 0; i < n; i++ {
		uf.parent[i] = i
		uf.rank[i] = 0
	}
	return uf
}

// 1 2 3 4
// 1 1 2 3
// 1 1 1 1

func (uf *UnionFind) find(node int) int {
	if uf.parent[node] != node {
		uf.parent[node] = uf.find((uf.parent[node]))
	}

	return uf.parent[node]
}

func (uf *UnionFind) union(node1 int, node2 int) {
	root1 := uf.find(node1)
	root2 := uf.find(node2)

	if root1 == root2 {
		return
	}

	if uf.rank[root1] > uf.rank[root2] {
		uf.parent[root2] = root1
	} else if uf.rank[root2] > uf.rank[root1] {
		uf.parent[root1] = root2
	} else {
		uf.parent[root2] = root1
		uf.rank[root1]++
	}

}

func main() {

	uf := NewUnionFind(5)

	uf.union(0, 1)
	uf.union(1, 2)
	uf.union(3, 4)

	fmt.Println(uf.find(0)) // Output: 0
	fmt.Println(uf.find(1)) // Output: 0
	fmt.Println(uf.find(2)) // Output: 0
	fmt.Println(uf.find(3)) // Output: 3
	fmt.Println(uf.find(4)) // Output: 3

}
