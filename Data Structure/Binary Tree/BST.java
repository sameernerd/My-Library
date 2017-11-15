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
		public void delete(int e){
		delete(e,root);
	}
	private Node minValueNode(Node root){
		while(root.left!=null)root=root.left;
		return root;
	}
	private Node delete(int item,Node root){
		Node temp;
		if(root==null){
			System.out.println("Tree is empty");
		}
		else if(item<root.data)root.left=delete(item,root.left);
		else if(item>root.data) root.right=delete(item,root.right);
		else{
			if(root.left==null){
				temp=root.right;
				return temp;
			}
			else if(root.right==null){
				temp=root.left;
				return temp;
			}
			temp=minValueNode(root.right);
			root.data=temp.data;
			root.right=delete(temp.data,root.right);
		}
		return root;
	}
}
