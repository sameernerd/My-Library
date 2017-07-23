//Implementing Binary Search Tree
public class BinaryTree {
	
	public class Node{
		int data;
		Node left;
		Node right;
	}
	
	private Node GetNewNode(int data){
		Node newNode=new Node();
		newNode.data=data;
		newNode.left=null;
		newNode.right=null;
		return newNode;
	}
	
	public Node insert(Node root,int data){
		if(root==null){
			root=GetNewNode(data);
			return root;
		}
		else if(data<=root.data){
			root.left=insert(root.left,data);
		}
		else if(data>root.data){
			root.right=insert(root.right,data);
		}
		return root;
	}
	
	
	//Worst case for searching is O(n) in regular BST and O(logn) in Balanced BST
	public Node search(int data,Node root){
		Node node=null;
		if(root.data==data)return root;
		else if(data<root.data)node=search(data,root.left);
		else node=search(data,root.right);
		return node;
	}
	
}
