import java.util.*;

public class MinHeap {
    HashMap<Character,Integer> MinHash=new HashMap();  //Holding character to a position
	private ArrayList<Node> ar=new ArrayList();       //Holding node objects
	//Representing each vertex
	class Node{
		int weight;
		char key;
	}
	
	int getParent(int index){return (index-1)/2;}
	int getLeft(int index){return (index*2+1);}
	int getRight(int index){return (index*2+2);}
	boolean hasParent(int childIndex){if(getParent(childIndex)>=0)return true;else return false;}
	

	
	//helping method for swapping
	void swap(Node child,Node parent){
		int weight=child.weight;
		Character data=child.key;
		
		child.weight=parent.weight;
		child.key=parent.key;
		
		parent.key=data;
		parent.weight=weight;
	}
	//Inserting the vertex
		void insert(int weight,char key){
			Node newNode=new Node();
			newNode.key=key;
			newNode.weight=weight;
			ar.add(newNode);  //Making an array of nodes
			MinHash.put(key,ar.size()-1);
			bubbleUp(ar.size()-1);
			
		}
	
	//Extracting the minimum value
		char ExtractMin(){
			if(ar.size()==1){
				MinHash.remove(ar.get(0).key);
				return ar.get(0).key;
			}
			Node minNode=ar.get(0);
			char key=minNode.key;
			MinHash.remove(minNode.key);
			ar.set(0,ar.get(ar.size()-1));
			MinHash.put(ar.get(ar.size()-1).key,0);
			ar.remove(ar.size()-1);
			bubbleDown(ar.get(0));
			return key;
		}
		
	void bubbleUp(int childIndex){
		Node childNode=ar.get(childIndex);
		while(hasParent(childIndex)&&ar.get(getParent(childIndex)).weight>childNode.weight){
			updateMap(childNode,ar.get(getParent(childIndex)),childIndex,getParent(childIndex));
			swap(childNode,ar.get(getParent(childIndex)));
			childIndex=getParent(childIndex);
			bubbleUp(childIndex);
		}
	}
	
	void showArray(){
		System.out.println();
		for(int i=0;i<ar.size();i++)
			System.out.print(ar.get(i).key+" ");
		System.out.println();
	}
	
	void bubbleDown(Node parent){
		int parentIndex=MinHash.get(parent.key);
		int leftIndex=getLeft(MinHash.get(parent.key));
		int rightIndex=getRight(MinHash.get(parent.key));
		
		int smallest_index;
		if(leftIndex<ar.size()&&ar.get(leftIndex).weight<(int)ar.get(parentIndex).weight)smallest_index=leftIndex;
		else smallest_index=parentIndex;
		if(rightIndex<ar.size()&&ar.get(rightIndex).weight<ar.get(smallest_index).weight)smallest_index=rightIndex;
		if(smallest_index!=parentIndex){
			updateMap(ar.get(smallest_index),parent,smallest_index,parentIndex);
			swap(ar.get(smallest_index),parent);
			bubbleDown(ar.get(smallest_index));
		}
	}
	
	void decrease(int newData,Character key){
		int initial_index=MinHash.get(key);
		Node child=ar.get(initial_index);
		child.weight=newData;
		bubbleUp(initial_index);
	}
	boolean contains(char key){
		if(MinHash.containsKey(key))return true;
		else return false;
	}
	void updateMap(Node child,Node parent,int cindex,int pindex){
		MinHash.remove(child.key);
		MinHash.remove(parent.key);
		MinHash.put(child.key, pindex);
		MinHash.put(parent.key, cindex);
	}
	 
	boolean isEmpty(){
		if(MinHash.isEmpty())return true;
		else return false;
	}
	
	int getHeapNodeValue(Character key){
		return ar.get(MinHash.get(key)).weight;
	}
	
	void showMap(){
		Set<Map.Entry<Character, Integer>>set=MinHash.entrySet();
		for(Map.Entry<Character,Integer> me:set){
			System.out.print(me.getKey()+" "+me.getValue()+"  ");
		}
	}
}

//key and value is the position in the array 