	//Level order traversal in reverse direction
	public void revereseLevelorderTraversal(Node root){
		if(root==null)return;
		Queue<Node> queue=new LinkedList<Node>();
		Stack<Node> st=new Stack<Node>();
		queue.add(root);
		Node temp;
		while(!queue.isEmpty()){
			temp=queue.poll();
			st.add(temp);
			if(temp.right!=null)queue.add(temp.right);
			if(temp.left!=null)queue.add(temp.left);
		}
		while(!st.isEmpty()){
			System.out.print(st.pop().data+" ");
		}
	}
