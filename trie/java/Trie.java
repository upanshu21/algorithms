package trie.java;

class Node {

    Node links[] = new Node[26];
    boolean flag = false;

    public Node () {}

    boolean containsKey(char key) {
        return links[key - 'a'] != null;
    }

    Node get(char key) {
        return links[key - 'a'];
    }

    void put(char key, Node node) {
        links[key - 'a'] = node;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }

}

public class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }   

    public void insert(String word) { 
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for (int i=0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        if (node.isEnd()) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String word) {
        Node node = root;
        for(int i = 0; i< word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return true;
    }

}

