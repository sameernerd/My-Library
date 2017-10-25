import java.util.HashMap;

public class Trie {
	private TrieNode root;
	private class TrieNode{
		private HashMap<Character,TrieNode> map;
		private boolean endOfWord;
		TrieNode(){
			map=new HashMap<Character,TrieNode>();
			endOfWord=false;
		}
	}
	Trie(){
		root=new TrieNode();
	}
	public void insert(String s){
		TrieNode current=root,node;
		for(int i=0;i<s.length();i++){
			node=current.map.get(s.charAt(i));
			if(node==null){
				node=new TrieNode();
				current.map.put(s.charAt(i),node);
			}
			current=node;
		}
		current.endOfWord=true;  //End of the word
	}
	public boolean search(String s){
		TrieNode current=root;
		for(int i=0;i<s.length();i++){
			if(current.map.get(s.charAt(i))!=null){
				current=current.map.get(s.charAt(i));
			}
			else return false;
		}
		return current.endOfWord;
	}
	public void delete(String s){
		delete(root,s,0);
	}
	private boolean delete(TrieNode current,String s,int index){
		if(index==s.length()){
			if(!current.endOfWord){
				return false;
			}
			else return current.map.size()==0;
		}
		TrieNode node=current.map.get(s.charAt(index));
		if(node==null){
			return false;
		}
		boolean shouldBeDeleted=delete(node,s,index+1);
		if(shouldBeDeleted){
			current.map.remove(s.charAt(index));
			return current.map.size()==0;
		}
		return false;
	}
}
