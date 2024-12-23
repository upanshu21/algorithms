package graphs.unionfind.withSize.java;

import java.util.ArrayList;
import java.util.List;

public class UnionFind {

    public List<Integer> parent = new ArrayList<>();
    public List<Integer> size = new ArrayList<>();

    private UnionFind(int n) {
        for (int i= 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int find(int node) {
        if (parent.get(node) == node) { return node; }
        parent.set(node, find(parent.get(node)));
        return parent.get(node);
    }

    public void union(int node1, int node2) {

        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) { return; }

        if (size.get(root2) > size.get(root1)) {
            parent.set(root1, root2);
            size.set(root2, size.get(root2)+ size.get(root1));
        } else {
            parent.set(root2, root1);
            size.set(root1, size.get(root1)+ size.get(root2));

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
