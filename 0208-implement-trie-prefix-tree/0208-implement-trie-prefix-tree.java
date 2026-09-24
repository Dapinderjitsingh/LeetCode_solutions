class Trie {
    class TrieNode{
        TrieNode children[];
        boolean isend;
        TrieNode(){
            children = new TrieNode[26];
            isend = false;
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isend = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return current.isend;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */