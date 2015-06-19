package Ch201_220;

/**
 * Created by hadoop on 2015/6/11 0011.
 */
public class WordDictionary {
    class TrieNode {
        // Initialize your data structure here.
        TrieNode[] elements = new TrieNode[26];
        boolean isLast = false;

        public TrieNode() {

        }
    }
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
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


    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        return doSearch(word,root);
    }
    public boolean doSearch(String word,TrieNode root){
        char c= word.charAt(0);
        if(word.length()==1){
            if(c=='.'){
                for(TrieNode node:root.elements){
                    if(node!=null&&node.isLast)
                        return true;
                }
            }else {
                if(root.elements[c-97]!=null&&root.elements[c-97].isLast)
                    return true;
            }
        }else {
            if (c=='.'){
                for(TrieNode node:root.elements){
                    if(node!=null&&doSearch(word.substring(1),node))
                        return true;
                }
            }else{
                int index = c - 97;
                if(root.elements[index]==null)
                    return false;
                else
                    return doSearch(word.substring(1),root.elements[index]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        System.out.println(dictionary.search("pad") + ", false");
        System.out.println(dictionary.search("bad") + ", true");
        System.out.println(dictionary.search(".ad") + ", true");
        System.out.println(dictionary.search("b..")+", true");
    }
}
