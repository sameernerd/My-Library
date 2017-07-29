	public int lowestCommonAncestorBST(Node root,int d1,int d2){
	    if(Math.min(d1, d2)>root.data)return lowestCommonAncestorBST(root.right,d1,d2);
		else if(Math.max(d1, d2)<root.data)return lowestCommonAncestorBST(root.left,d1,d2);
		else return root.data;
	}
  
	public Node lowestCommonAncestorBT(Node root,int d1,int d2){
		if(root==null)return null;
		if(root.data==d1||root.data==d2)return root;
		Node left=lowestCommonAncestorBT(root.left,d1,d2);
		Node right=lowestCommonAncestorBT(root.right,d1,d2);
		if(left!=null&&right!=null)return root;
		if(left==null&&right==null)return null;
		return left!=null?left:right;
	}

	//Largest Binary Search Tree in a Binary Trees
	private LargestBST largest(Node root){
		if(root==null)return new LargestBST();
		LargestBST left=largest(root.left);
		LargestBST right=largest(root.right);
		LargestBST l=new LargestBST();
		if(left.isBST==false||right.isBST==false||root.data<=left.max||root.data>right.min){
			l.isBST=false;
			l.size=Math.max(left.size, right.size);
			return l;
		}
		l.isBST=true;
		l.size=left.size+right.size+1;
		l.min=root.right!=null?left.min:root.data;
		l.max=root.left!=null?right.max:root.data;
		return l;
	}
