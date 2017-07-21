	public Node Insert(int data,Node root){
		Node node=new Node(data);
		Node parent=null,current=root;
		if(root==null)return null;
		while(current!=null){
			parent=current;
			if(data>current.data){
				current=current.right;
			}
			else if(data<=current.data){
				current=current.left;
			}
		}
		if(data>parent.data){
			parent.right=node;
		}
		else parent.left=node;
		return root;
	}
