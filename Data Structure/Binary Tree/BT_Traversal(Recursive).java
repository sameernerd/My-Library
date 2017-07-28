//Depth First Traversal
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

*******************************************************************************************************************************************
    //Level Order Traversal
	public void levelOrderTraverse(Node root){
		if(root==null)return;
		Queue<Node> queue=new LinkedList();
		queue.add(root);
		Node temp_node=null;
		while(!queue.isEmpty()){
			temp_node=queue.poll();
			System.out.println(temp_node.data);
			if(temp_node.left!=null)queue.add(temp_node.left);
			if(temp_node.right!=null)queue.add(temp_node.right);
		}
	}
