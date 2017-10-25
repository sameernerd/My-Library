
public class TrieMain {
	public static void main(String[] args) {
		Trie trie=new Trie();
		trie.insert("abc");
		trie.insert("abmcde");
		trie.insert("abmcdefg");
		trie.insert("l");
		trie.insert("lmno");
		System.out.println(trie.search("abc"));
		trie.delete("abc");
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("abmcde"));
	}

}
