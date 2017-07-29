	public void spiralLevelOrderTraversal(Node root){
		if(root==null)return;
		Stack<Node> st1=new Stack<Node>();
		Stack<Node> st2=new Stack<Node>();
		st1.add(root);
		Node current=null;
		while(!st1.isEmpty()||!st2.isEmpty()){
			while(!st1.isEmpty()){
				current=st1.pop();
				System.out.print(current.data+" ");
				if(current.left!=null)st2.add(current.left);
				if(current.right!=null)st2.add(current.right);
			}
			if(st1.isEmpty()){
				while(!st2.isEmpty()){
					current=st2.pop();
					System.out.print(current.data+" ");
					if(current.right!=null)st1.add(current.right);
					if(current.left!=null)st1.add(current.left);
				}
			}
		}
	}
