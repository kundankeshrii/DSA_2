class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int idx = -1;
    }

    TrieNode root = new TrieNode();

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        // Root should also contain best global answer
        for (int i = 0; i < wordsContainer.length; i++) {
            update(root, wordsContainer, i);

            TrieNode node = root;
            String word = wordsContainer[i];

            for (int j = word.length() - 1; j >= 0; j--) {

                int c = word.charAt(j) - 'a';

                if (node.child[c] == null) {
                    node.child[c] = new TrieNode();
                }

                node = node.child[c];

                update(node, wordsContainer, i);
            }
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {

            TrieNode node = root;
            String q = wordsQuery[i];

            for (int j = q.length() - 1; j >= 0; j--) {

                int c = q.charAt(j) - 'a';

                if (node.child[c] == null) {
                    break;
                }

                node = node.child[c];
            }

            ans[i] = node.idx;
        }

        return ans;
    }

    private void update(TrieNode node, String[] words, int idx) {

        if (node.idx == -1) {
            node.idx = idx;
            return;
        }

        String curr = words[idx];
        String prev = words[node.idx];

        if (curr.length() < prev.length()) {
            node.idx = idx;
        }
        else if (curr.length() == prev.length() && idx < node.idx) {
            node.idx = idx;
        }
    }
}