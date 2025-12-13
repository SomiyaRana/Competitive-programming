import java.util.*;

class Solution {

    // ✅ ADD THIS CLASS
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    List<String> result = new ArrayList<>();
    int rows, cols;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] == '#')
            return;

        char ch = board[r][c];
        TrieNode next = node.children[ch - 'a'];
        if (next == null) return;

        if (next.word != null) {
            result.add(next.word);
            next.word = null; // avoid duplicates
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, next);
        dfs(board, r - 1, c, next);
        dfs(board, r, c + 1, next);
        dfs(board, r, c - 1, next);

        board[r][c] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
        return root;
    }
}
