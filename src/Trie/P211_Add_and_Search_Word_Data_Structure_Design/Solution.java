package Trie.P211_Add_and_Search_Word_Data_Structure_Design;

public class Solution {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }

    class WordDictionary {

        private TrieNode root = new TrieNode();

        /** Initialize your data structure here. */
        public WordDictionary() {
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.'
         * to represent any one letter. */
        public boolean search(String word) {
            return match(word.toCharArray(), 0, root);
        }

        private boolean match(char[] chars, int k, TrieNode node) {
            if (k == chars.length) {
                return node.isWord;
            }

            if (chars[k] == '.') {
                for(int i = 0; i < node.children.length; i++ ){
                    if (node.children[i] != null && match(chars, k + 1, node.children[i])) {
                        return true;
                    }
                }
            } else {
                return node.children[chars[k] - 'a'] != null && match(chars, k + 1, node.children[chars[k] - 'a']);
            }

            return false;
        }
    }
}
