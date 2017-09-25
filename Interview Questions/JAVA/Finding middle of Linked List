/*
Given a singly linked list, find middle of the linked list. For example, 
if given linked list is 1->2->3->4->5 then output should be 3.
If there are even nodes, then there would be two middle nodes, we need to print second middle element. 
For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
-------------------------------------------------------------------------------------------------------------------------------------------
Using two pointer technique
i will be the slow pointer and j will be the fast pointer
-------------------------------------------------------------------------------------------------------------------------------------------
File contains two class :- One basic single Linked List implementation and other Main class.
Method name :- findMid
*/
public class LinkedList {
	class Node{
		private int data;
		private Node next;
		Node (int d,Node start){
			data=d;
			next=null;
		}
	}
	public Node insertLast(int data,Node root){
		if(root==null){
			root=new Node(data,root);
			return root;
		}
		Node temp=root;
		while(temp.next!=null){
			temp=temp.next;
		}
		Node newNode;
		newNode=new Node(data,root);
		temp.next=newNode;
		return newNode;
	}
	public void findMid(Node root){
		Node i=root,j=root;
		while(j!=null){
			j=j.next;
			if(j!=null){
				j=j.next;
				i=i.next;
			}
		}
		System.out.println(i.data);
	}
}

//Main Class

public class MyMain {
	public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		LinkedList.Node root=null;
		root=ll.insertLast(1, root);
		ll.insertLast(2, root);
		ll.insertLast(3, root);
		ll.insertLast(4, root);
		ll.insertLast(5, root);
		ll.insertLast(6, root);
		ll.insertLast(10, root);
		ll.insertLast(12, root);
		ll.insertLast(17, root);
		ll.insertLast(18, root);
		ll.insertLast(19, root);
		ll.insertLast(21, root);
		ll.insertLast(22, root);
		ll.insertLast(25, root);
		ll.findMid(root);
    //Output should be 12
	}

}
