//Time complexity of AVL tree is O(logn) for insertion,search and deletion

public class AVLTree {
	
	public class Node{
		int data;
		int height;
		Node left;
		Node right;
		Node(){}
		Node(int data){
			this.data=data;
			height=0;
		}
	}
	
	private Node GetNewNode(int data){
		Node newNode=new Node();
		newNode.data=data;
		newNode.left=null;
		newNode.right=null;
		newNode.height=1;
		return newNode;
	}
	
	private Node rightRotate(Node root) {
		Node newRoot=root.left;
		root.left=newRoot.right;
		newRoot.right=root;
		root.height=Math.max(height(root.right),height(root.left))+1;
		newRoot.height=Math.max(height(newRoot.right),height(newRoot.left))+1;
		return newRoot;
		
	}
	
	private Node leftRotate(Node root){
		Node newRoot=root.right;
		root.right=newRoot.left;
		newRoot.left=root;
		root.height=Math.max(height(root.right),height(root.left))+1;
		newRoot.height=Math.max(height(newRoot.right),height(newRoot.left))+1;
		return newRoot;
	}
	
	private int height(Node node){
		try{
			return node.height;
		}catch(NullPointerException exc){
			return 0;
		}
	}
	//Insertion in AVL Tree
	public Node insert(Node root,int data){
		if(root==null){
			root=GetNewNode(data);
			return root;
		}
		else if(data<=root.data){
			root.left=insert(root.left,data);
			root.height=Math.max(root.left.height+1,root.height);
		}
		else if(data>root.data){
			root.right=insert(root.right,data);
			root.height=Math.max(root.right.height+1,root.height);
		}
		int balance=height(root.left)-height(root.right);
		if(balance>1){
			if(height(root.left.left)>=height(root.left.right)){ //Left-Left case
				root= rightRotate(root);
			}
			else{ //Left-Right
				root.left=leftRotate(root.left);
				root= rightRotate(root);
			}
		}
	    if(balance<-1){
			if(height(root.right.right)>=height(root.right.left)){//Right-Right
				root= leftRotate(root);
			}
			else{//Right-Left
				root.right=rightRotate(root.right);
				root= leftRotate(root);
			}
		}
	   
	    root.height=Math.max(height(root.left), height(root.right))+1;
		return root;
	}
}
