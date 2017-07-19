import java.util.Arrays;

//Formula
/*
 * Parent index=(childindex-1)/2
 * left-child=index*2+1
 * right-child=index*2+2
 */
public class MinHeap {
	private int n;
	private int ar[];
	private int size=0;
	MinHeap(){
	//Default Constructor	
	}
	MinHeap(int n){
		this.n=n;
		ar=new int[n];
	}
	
	private int  getLeftChildIndex(int parentIndex){return parentIndex*2+1;}
	private int getRightChildIndex(int parentIndex){return parentIndex*2+2;}
	private int getParentIndex(int childIndex){return (childIndex-1)/2;}
	
	private boolean hasLeftChild(int parentIndex){return getLeftChildIndex(parentIndex)<size;}
	private boolean hasRightChild(int parentIndex){return getRightChildIndex(parentIndex)<size;}
	private boolean hasParent(int childIndex){return getParentIndex(childIndex)>=0;}
	
	private int leftChild(int parentIndex){return ar[getLeftChildIndex(parentIndex)];}
	private int rightChild(int parentIndex){return ar[getRightChildIndex(parentIndex)];}
	private int parent(int childIndex){return ar[getParentIndex(childIndex)];}
	
	private void swap(int i,int j){
		int temp=ar[i];
		ar[i]=ar[j];
		ar[j]=temp;
	}
	private void ensureExtraCapacity(){
		if(size==n){
			ar=Arrays.copyOf(ar, n*2);
		}
	}
	public int peek(){
		if(size==0)throw new IllegalStateException();
		else return ar[0];
	}
	public int extractMin(){
		if(size==0)throw new IllegalStateException();
		else{
			int item=ar[0];
			ar[0]=ar[size-1];
			size--;
			heapifyDown();
			return item;
		}
	}
	public void add(int item){
		ensureExtraCapacity();
		ar[size]=item;
		size++;
		heapifyUp();
	}
	private void heapifyUp(){
		int index=size-1;
		while(hasParent(index)&&parent(index)>ar[index]){
			swap(getParentIndex(index),index);
			index=getParentIndex(index);
		}
	}
	private void heapifyDown(){
		int index=0,smallestChildIndex;
		while(hasLeftChild(index)){
			smallestChildIndex=getLeftChildIndex(index);
			if(hasRightChild(index)&&rightChild(index)<leftChild(index)){
				smallestChildIndex=getRightChildIndex(index);
			}
			if(ar[index]<ar[smallestChildIndex])break;
			else{
				swap(index,smallestChildIndex);
				index=smallestChildIndex;
			}
		}
	}
}
