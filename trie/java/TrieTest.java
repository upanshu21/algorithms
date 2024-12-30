package trie.java;

import trie.java.Trie;


class TrieTest {

    public static void main(String[] args) {
        TrieTest test = new TrieTest();
        test.testInsertAndSearch();
        test.testStartsWith();
        test.testSearchNonExistentWord();
        test.testStartsWithNonExistentPrefix();
        System.out.println("All tests passed!");
    }

    void testInsertAndSearch() {
        Trie trie = new Trie();
        trie.insert("apple");
        assert trie.search("apple") : "The word 'apple' should be found after insertion";
        assert !trie.search("app") : "The word 'app' should not be found as a complete word";
        trie.insert("app");
        assert trie.search("app") : "The word 'app' should be found after insertion";
    }

    void testStartsWith() {
        Trie trie = new Trie();
        trie.insert("apple");
        assert trie.startsWith("app") : "The prefix 'app' should be found";
        assert trie.startsWith("apple") : "The prefix 'apple' should be found";
        assert !trie.startsWith("applf") : "The prefix 'applf' should not be found";
    }

    void testSearchNonExistentWord() {
        Trie trie = new Trie();
        trie.insert("apple");
        assert !trie.search("banana") : "The word 'banana' should not be found";
    }

    void testStartsWithNonExistentPrefix() {
        Trie trie = new Trie();
        trie.insert("apple");
        assert !trie.startsWith("ban") : "The prefix 'ban' should not be found";
    }
}