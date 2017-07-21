	//Checking if given two BT is similar or not
	public boolean isSimilar(Node root1,Node root2){
		//System.out.println(root1.data+" "+root2.data);
		if(root1==null&&root2==null)return true;
		if(root1==null||root2==null)return false;
		return root1.data==root2.data
		   && isSimilar(root1.left,root2.left)
		   && isSimilar(root1.right,root2.right);
	}
