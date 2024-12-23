package graphs.unionfind.withRank.java;

import java.util.*;

public class UnionFind {

    public List<Integer> parent = new ArrayList<>();
    public List<Integer> rank = new ArrayList<>();

    public UnionFind(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(1);
        }
    }

    public int find(int node) {
        
        if (node == parent.get(node)) {
            return node;
        }

        parent.set(node, find(parent.get(node)));
        return parent.get(node);
    }

    public void union(int node1, int node2) {

        int parent1 = find(node1);
        int parent2 = find(node2);

        if (parent1 == parent2) {
            return;
        }

        if (rank.get(parent1) > rank.get(parent2)) {
            parent.set(parent2, parent1);
        } else if (rank.get(parent1) < rank.get(parent2)) {
            parent.set(parent1, parent2);
        } else {
            parent.set(parent2, parent1);
            rank.set(parent1, rank.get(parent1) + 1);
        }

    }

    public static void main(String[] args) {

        UnionFind uf = new UnionFind(5);
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);

        System.out.println(uf.find(0));
        System.out.println(uf.find(1));
        System.out.println(uf.find(2));
        System.out.println(uf.find(3));
        System.out.println(uf.find(4));

    }
}