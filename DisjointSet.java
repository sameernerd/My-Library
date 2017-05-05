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
		Node node1=DisjointMap.get(data1);
        Node node2=DisjointMap.get(data2);
        
        Node parent1=findSet(node1);
        Node parent2=findSet(node2);
        
        if(parent1.data==parent2.data)return;
        else if(parent1.rank>=parent2.rank){
            if(parent1.rank==parent2.rank)parent1.rank++;
            parent2.parent=parent1;
        }
        else{
            parent1.parent=parent2;
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
