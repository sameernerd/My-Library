//Visit->Left->Right
	public void Preorder(Node root){
		if(root==null)return;
		else System.out.println(root.data);
		Preorder(root.left);
		Preorder(root.right);
	}
	
	//Left->Visit->Right
	public void Inorder(Node root){
		if(root==null)return;
		Inorder(root.left);
		System.out.println(root.data);
		Inorder(root.right);
	}
	
    //Left->Right->Visit
	public void Postorder(Node root){
		if(root==null)return;
		Postorder(root.left);
		Postorder(root.right);
		System.out.println(root.data);
	}
