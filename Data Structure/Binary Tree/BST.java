public class BinaryTree {
	private Node root;
	private class Node{
		int data;
		Node left;
		Node right;
	}
	BinaryTree(){
		root=null;
	}
	public void insert(int value){
		root=insert(root,value);
	}
	private Node insert(Node root,int value){
		if(root==null){
			root=new Node();
			root.data=value;
			root.left=null;
			root.right=null;
		}
		else if(value<root.data)root.left=insert(root.left,value);
		else root.right=insert(root.right,value);
		return root;
	}
	public boolean search(int data){
		if(search(data,root)!=null)return true;
		else return false;
	}
	private Node search(int data,Node root){
		Node node=null;
		if(root==null||root.data==data)return root;
		else if(data<root.data)node=search(data,root.left);
		else node=search(data,root.right);
		return node;
	}
}
