import java.util.*;

public class DisjointSet {
	HashMap<Long,Node> DisjointMap=new HashMap();
	
	void makeSet(long data){
		Node newNode=new Node();
		newNode.data=data;
		newNode.rank=0;
		newNode.parent=newNode;
		DisjointMap.put(data,newNode);
	}
	
	void Union(long data1,long data2){
		if(DisjointMap.get(new Long(data1))==DisjointMap.get(new Long(data2)))return;
		if(DisjointMap.get(new Long(data1)).rank>=DisjointMap.get(new Long(data2)).rank){
			DisjointMap.get(new Long(data2)).parent=DisjointMap.get(new Long(data1));
			DisjointMap.get(new Long(data1)).rank++;
		}
		else if(DisjointMap.get(new Long(data2)).rank>DisjointMap.get(new Long(data1)).rank){
			DisjointMap.get(new Long(data1)).parent=DisjointMap.get(new Long(data2));
			DisjointMap.get(new Long(data2)).rank++;
		}
	}
	
	public long findSet(long data1){
		return findSet(DisjointMap.get(data1)).data;
	}
	
	private Node findSet(Node node){
		Node parent=node.parent;
		if(parent==node)return node;
		node.parent=findSet(node.parent);
		return node.parent;
	}
}