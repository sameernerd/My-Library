//PostOrder Traversal using Iterative method
	public void PostorderIterative(Node root){
		if(root==null)return;
		Stack<Node> stack1=new Stack();
		Stack<Node> stack2=new Stack();
		stack1.add(root);
		Node temp_node=null;
		while(!stack1.isEmpty()){
			temp_node=stack1.pop();
			if(temp_node.left!=null)stack1.add(temp_node.left);
			if(temp_node.right!=null)stack1.add(temp_node.right);
			stack2.add(temp_node);
		}
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop().data+" ");
		}
	}
