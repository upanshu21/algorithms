package graphs.unionfind.withRank.java;

class UnionFindTest {

    public static void main(String[] args) {
        UnionFindTest test = new UnionFindTest();
        test.testFindInitiallyReturnsSelf();
        test.testUnionMergesComponents();
        test.testUnionHandlesDifferentRanks();
        test.testFindWithPathCompression();
        test.testDisconnectedComponents();
        test.testSelfUnion();
        System.out.println("All tests passed!");
    }

    void testFindInitiallyReturnsSelf() {
        UnionFind uf = new UnionFind(5);
        for (int i = 0; i < 5; i++) {
            assert uf.find(i) == i : "Each node should initially be its own parent";
        }
    }

    void testUnionMergesComponents() {
        UnionFind uf = new UnionFind(5);
        uf.union(0, 1);
        assert uf.find(0) == uf.find(1) : "Nodes 0 and 1 should have the same root after union";

        uf.union(1, 2);
        assert uf.find(0) == uf.find(2) : "Nodes 0, 1, and 2 should have the same root after unions";
    }

    void testUnionHandlesDifferentRanks() {
        UnionFind uf = new UnionFind(5);
        uf.union(0, 1); // Merge 0 and 1
        uf.union(2, 3); // Merge 2 and 3

        int rankBefore = uf.rank.get(uf.find(0));

        uf.union(0, 2); // Merge the two sets

        assert uf.find(0) == uf.find(3) : "All nodes should have the same root after unions";
        assert uf.rank.get(uf.find(0)) == rankBefore + 1 : "Rank should increase after merging sets of equal rank";
    }

    void testFindWithPathCompression() {
        UnionFind uf = new UnionFind(5);
        uf.union(0, 1);
        uf.union(1, 2);

        int root = uf.find(2);

        assert uf.parent.get(0) == root : "Path compression should make all nodes point directly to the root";
        assert uf.parent.get(1) == root : "Path compression should make all nodes point directly to the root";
        assert uf.parent.get(2) == root : "Path compression should make all nodes point directly to the root";
    }

    void testDisconnectedComponents() {
        UnionFind uf = new UnionFind(5);
        uf.union(0, 1);
        uf.union(2, 3);

        assert uf.find(0) != uf.find(2) : "Disconnected components should not have the same root";
        assert uf.find(1) != uf.find(3) : "Disconnected components should not have the same root";

        uf.union(3, 4);
        assert uf.find(2) == uf.find(4) : "Nodes 2, 3, and 4 should share the same root after unions";
    }

    void testSelfUnion() {
        UnionFind uf = new UnionFind(5);
        uf.union(0, 0);
        assert uf.find(0) == 0 : "Union of a node with itself should not change its root";
    }
}
