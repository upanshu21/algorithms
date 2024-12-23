package main

import "fmt"

type UnionFind struct {
	parent []int
	size   []int
}

func NewUnionFind(n int) *UnionFind {
	uf := &UnionFind{
		parent: make([]int, n),
		size:   make([]int, n),
	}
	for i := 0; i < n; i++ {
		uf.parent[i] = i
		uf.size[i] = 1
	}
	return uf
}

func (uf *UnionFind) find(node int) int {
	if node == uf.parent[node] {
		return node
	}
	uf.parent[node] = uf.find(uf.parent[node])
	return uf.parent[node]
}

func (uf *UnionFind) union(node1 int, node2 int) {
	root1 := uf.find(node1)
	root2 := uf.find(node2)

	if root1 == root2 {
		return
	}

	if uf.size[root1] < uf.size[root2] {
		uf.parent[root1] = root2
		uf.size[root2] += uf.size[root1]
	} else {
		uf.parent[root2] = root1
		uf.size[root1] += uf.size[root2]
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
