package Ch201_220;

import com.huihui.util.ArrayUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hadoop on 2015/6/14 0014.
 */
public class Ch212 {
    Set<String> result = new HashSet<>();
    class TrieNode {
        TrieNode[] elements = new TrieNode[26];
        char currentChar;
        TrieNode parent;
        boolean isLast = false;

        public TrieNode(TrieNode parent) {
            this.parent = parent;
        }

        public TrieNode(TrieNode parent,char currentChar) {
            this.currentChar = currentChar;
            this.parent = parent;
        }
    }
    private TrieNode root = new TrieNode(null);

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null)
            return;
        TrieNode begin = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int) word.charAt(i) - 97;
            if (begin.elements[index] == null)
                begin.elements[index] = new TrieNode(begin,word.charAt(i));
            begin = begin.elements[index];
            if (i == word.length() - 1) {
                begin.isLast = true;
            }
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        for(String word:words){
            insert(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                doFindWords(board,i,j,visited,root);
            }
        }
        return new ArrayList<>(result);
    }

    public void doFindWords(char[][] board,int i,int j,boolean[][] visited,TrieNode trieNode ){
        if(trieNode.isLast){
            StringBuilder sb = new StringBuilder();
            TrieNode begin = trieNode;
            while(begin.parent!=null){
                sb.append(begin.currentChar);
                begin = begin.parent;
            }
            result.add(sb.reverse().toString());
        }
        if(i<0||j<0||i==board.length||j==board[0].length||visited[i][j]) return;
        if(trieNode.elements[board[i][j]-97]==null){
            return ;
        }
        trieNode = trieNode.elements[board[i][j]-97];
        visited[i][j] = true;

        doFindWords(board,i,j-1,visited,trieNode);
        doFindWords(board,i,j+1,visited,trieNode);
        doFindWords(board,i-1,j,visited,trieNode);
        doFindWords(board,i+1,j,visited,trieNode);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
       // String[] words =  {"oath","pea","eat","rain","eae"};
//        char[][] board = {
//        {'o','a','a','n'},
//        {'e','t','a','e'},
//        {'i','h','k','r'},
//        {'i','f','l','v'}
//        };
        String[] arr  ={"baabab","abaaaa","abaaab","ababba","aabbab","aabbba","aabaab"};
       String[] words = {"bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"};
        char[][] board = ArrayUtil.switchStringArrToChar(arr);

        System.out.println(new Ch212().findWords(board,words));

    }
}
