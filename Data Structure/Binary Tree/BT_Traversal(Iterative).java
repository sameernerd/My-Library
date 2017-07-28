//PostOrder Traversal using Iterative method(Left->Right->Visit)
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
	//Iterative InOrder Traversal(Left->Visit->Right)
	public void InorderIterative(Node root){
		if(root==null)return;
		Stack<Node> st=new Stack();
		Node temp_node=root,node;
		while(true){
			if(temp_node!=null){
				st.add(temp_node);
				temp_node=temp_node.left;
			}
			if(temp_node==null){
				if(st.isEmpty())break;
				node=st.pop();
				System.out.print(node.data+" ");
				temp_node=node.right;
			}
		}
	}
	//Iterative PreOrder Traversal(Visit->Left->Right)
	public void PreorderIterative(Node root){
		if(root==null)return;
		Stack<Node> st=new Stack();
		st.add(root);
		Node temp=null;
		while(!st.isEmpty()){
			temp=st.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)st.push(temp.right);
			if(temp.left!=null)st.push(temp.left);
		}
	}
