	
	//Morris Inorder Tree Traversal(Left->Visit->Right) Time-O(n) Space-O(1)
	public void morrisInorderTraversaL(Node root){
		if(root==null)return;
		Node current=root;
		while(current!=null){
			if(current.left==null){
				System.out.print(current.data+" ");
				current=current.right;
			}
			else{
				Node pre=current.left;
				pre=findPredecessor(current);
				if(pre.right==null){
					pre.right=current;
					current=current.left;
				}
				else{
					pre.right=null;
					System.out.print(current.data+" ");
					current=current.right;
				}
			}
		}
	}
	private Node findPredecessor(Node current){
		Node pre=current.left;
		while(pre.right!=null&&pre.right!=current){
			pre=pre.right;
		}
		return pre;
	}
