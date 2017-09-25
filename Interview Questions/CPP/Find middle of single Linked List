
#include<iostream>
using namespace std;

class LinkedList{
	public:
	class Node{
		public:
		int data;
    	Node *next;	
	};
	//Inserting at the last of Linked List
	  Node* insertLast(Node *root,int data){
	  	Node *temp;
		temp=root;
		if(root==NULL){
			root=new Node();
			root->data=data;
			root->next=NULL;
			return root;
		}
		while(temp->next!=NULL){
			temp=temp->next;
		}
		Node *newNode=new Node();
		newNode->data=data;
		newNode->next=NULL;
		temp->next=newNode;
		return root;
	}
	void findMid(Node *root){
		Node *i=root,*j=root;
		while(j!=NULL){
			j=j->next;
			if(j!=NULL){
				j=j->next;
				i=i->next;
			}
		}
		cout<<i->data;
	}
};

int main(){
	LinkedList ll;
	LinkedList::Node *root;
	root=NULL;
	root=ll.insertLast(root,14);
	ll.insertLast(root,12);
	ll.insertLast(root,44);
	ll.insertLast(root,69);
	ll.insertLast(root,38);
	ll.insertLast(root,36);
	ll.insertLast(root,68);
	ll.findMid(root);
}
