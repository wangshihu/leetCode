package Ch201_220;

/**
 * Created by hadoop on 2015/6/11 0011.
 */


public class Trie {

    class TrieNode {
        // Initialize your data structure here.
        TrieNode[] elements = new TrieNode[26];
        boolean isLast = false;

        public TrieNode() {

        }
    }
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null)
            return;
        TrieNode begin = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int) word.charAt(i) - 97;
            if (begin.elements[index] == null)
                begin.elements[index] = new TrieNode();
            begin = begin.elements[index];
            if (i == word.length() - 1) {
                begin.isLast = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        TrieNode begin = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int) word.charAt(i) - 97;
            if(begin.elements[index]==null)
                return false;
            begin = begin.elements[index];
            if (i == word.length() - 1 && !begin.isLast)
                return false;

        }
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null )
            return false;
        TrieNode begin = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = (int) prefix.charAt(i) - 97;
            if(begin.elements[index] ==null)
                return false;
            begin = begin.elements[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("adc");
        trie.insert("a");
        System.out.println(trie.search("abc"));
        System.out.println(trie.startsWith("ad"));
        System.out.println(trie.search("a"));
    }
}
