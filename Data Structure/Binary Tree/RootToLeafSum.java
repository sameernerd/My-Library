//ROOT TO LEAF SUM
	//My Solution
	public boolean rootToLeafSum(Node root,int sum,ArrayList<Integer> result){
		boolean visit=false;
		if(root==null)return false;
		else if(root.left==null&&root.right==null){
			if(root.data==sum){
				result.add(root.data);
				return true;
			}
			else return false;
		}
		visit=rootToLeafSum(root.left,sum-root.data,result);
		if(visit)result.add(root.data);
	    if(visit!=true){
	    	visit=rootToLeafSum(root.right,sum-root.data,result);
	    	if(visit)result.add(root.data);
	    }
	    return visit;
	}
	//Tushar Roy's Solution
	public boolean RootToLeafSum(Node root,int sum,ArrayList<Integer> result){
		if(root==null)return false;
		else if(root.left==null&&root.right==null){
			if(root.data==sum){
				result.add(root.data);
				return true;
			}
			else return false;
		}
		if(rootToLeafSum(root.left,sum-root.data,result)){
			result.add(root.data);
			return true;
		}
	    if(rootToLeafSum(root.right,sum-root.data,result)){
	    	result.add(root.data);
	    	return true;
	    }
	    return false;
	}
