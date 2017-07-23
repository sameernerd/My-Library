//Size of Binary Tree
	public int size(Node root){
		if(root==null)return 0;
		int leftSize=size(root.left);
		int rightSize=size(root.right);
		return leftSize+rightSize+1;
	}
	//Height of Binary Tree
	public int height(Node root){
		if(root==null)return 0;
		int leftSize=height(root.left);
		int rightSize=height(root.right);
		return Math.max(leftSize, rightSize)+1;
	}
