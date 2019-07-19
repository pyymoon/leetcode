package com.leetcode.medium;

class TrieNode {
    public TrieNode[] next;
    public boolean is_end;

    public TrieNode() {
        //共26个字母
        next = new TrieNode[26];
        is_end = false;
    }
}

public class WordDictionary {
    public TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char s = word.charAt(i);
            if (node.next[s - 'a'] == null) {
                node.next[s - 'a'] = new TrieNode();
            }
            node = node.next[s - 'a'];
        }
        node.is_end = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    public boolean search(TrieNode node, String word, int i) {
        if (i >= word.length()) {
            return node.is_end;
        }
        //进行深度搜索
        char s = word.charAt(i);
        if (s == '.') {
            for (int j = 0; j < 26; j++) {
                if (node.next[j] != null && search(node.next[j], word, i + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.next[s - 'a'] != null && search(node.next[s - 'a'], word, i + 1)) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String a = "bad";
        String b = "mad";
        String c = "dad";
        WordDictionary wd = new WordDictionary();
        wd.addWord(a);
        wd.addWord(b);
        wd.addWord(c);
        wd.search("pad");
        wd.search("bad");
        wd.search(".ad");
        wd.search("b..");
    }
}
