#include<iostream>
using namespace std;

class LinkedList{
	public:
	class Node{
		public:
		int data;
    	Node *next;	
	};
	Node *root;
	LinkedList(){
		root=NULL;
	}
	//Inserting at the last of Linked List
	  void insertLast(int data){
	  	Node *temp;
		temp=root;
		if(root==NULL){
			root=new Node();
			root->data=data;
			root->next=NULL;
		}
		else{
			while(temp->next!=NULL){
			temp=temp->next;
			}
			Node *newNode=new Node();
			newNode->data=data;
			newNode->next=NULL;
			temp->next=newNode;
		}
	}
	//Traversing the linked list
	void traverse(){
		Node *temp=root;
		while(temp!=NULL){
			cout<<temp->data<<" ";
			temp=temp->next;
		}
		cout<<endl;
	}
	//Inserting at the beginning of linked list
	void insertFirst(int data){
		if(root==NULL){
			root=new Node();
			root->data=data;
			root->next=NULL;
		}
		Node *newNode=new Node();
		newNode->data=data;
		newNode->next=root;
		root=newNode;
	}
	//Deleting first node
	void deleteFirst(){
		if(root==NULL)return;
		else root=root->next;
	}
	//Deleting the last node
	void deleteLast(){
		if(root==NULL){
			cout<<"Linked List is empty";
		}
		Node *save=NULL;
		Node *temp=root;
		while(temp->next!=NULL){
			save=root;
			temp=temp->next;
		}
		if(save==NULL){
			cout<<"Linked List Empty Now"<<endl;
			root=NULL;
		}
		else save->next=NULL;
	}
	//Deleting the node with item
	void deleteItem(int item){
		Node *temp=root;
		if(temp->data==item){
			deleteFirst();
		}
		else{
			Node *save;
			while(temp!=NULL&&temp->data!=item){
				save=temp;
				temp=temp->next;
			}
			if(temp==NULL){
				cout<<"Item Not Found";
			}
			else save->next=temp->next;
		}
	}
};

int main(){
	LinkedList ll;
        ll.insertLast(14);
	ll.insertLast(12);
	ll.insertLast(44);
	ll.traverse();
	ll.insertFirst(16);
	ll.traverse();
	ll.deleteFirst();
	ll.deleteFirst();
	ll.deleteLast();
	ll.deleteLast();
	ll.insertFirst(67);
	ll.insertLast(69);
	ll.insertLast(38);
	ll.insertLast(36);
	ll.insertLast(68);
	ll.deleteItem(67);
	ll.traverse();
}
