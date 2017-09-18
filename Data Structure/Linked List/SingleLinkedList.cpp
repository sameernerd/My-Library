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
	//Traversing the linked list
	void traverse(Node *root){
		while(root!=NULL){
			cout<<root->data<<" ";
			root=root->next;
		}
		cout<<endl;
	}
	//Inserting at the beginning of linked list
	Node* insertFirst(Node *root,int data){
		if(root==NULL){
			root=new Node();
			root->data=data;
			root->next=NULL;
			return root;
		}
		Node *newNode=new Node();
		newNode->data=data;
		newNode->next=root;
		root=newNode;
		return root;
	}
	//Deleting first node
	Node* deleteFirst(Node *root){
		Node *newRoot;
		newRoot=root->next;
		root=NULL;
		return newRoot;
	}
	//Deleting the last node
	Node* deleteLast(Node *root){
		if(root==NULL)return NULL;
		Node *save=NULL;
		while(root->next!=NULL){
			save=root;
			root=root->next;
		}
		if(save==NULL){
			cout<<"Linked List Empty Now"<<endl;
			root=NULL;
			return root;
		}
		save->next=NULL;
	}
	//Deleting the node with item
	Node* deleteItem(Node *root,int item){
		if(root->data==item){
			deleteFirst(root);
		}
		else{
			Node *save,*temp=root;
			while(temp!=NULL&&temp->data!=item){
				save=temp;
				temp=temp->next;
			}
			if(temp==NULL){
				cout<<"Item Not Found";
				return root;
			}
			save->next=temp->next;
		}
	}
};

int main(){
	LinkedList ll;
	LinkedList::Node *root;
	root=NULL;
	root=ll.insertLast(root,14);
	ll.insertLast(root,12);
	ll.insertLast(root,44);
	ll.traverse(root);
	root=ll.insertFirst(root,16);
	ll.traverse(root);
	root=ll.deleteFirst(root);
	root=ll.deleteFirst(root);
	root=ll.deleteLast(root);
	root=ll.deleteLast(root);
	root=ll.insertFirst(root,67);
	ll.insertLast(root,69);
	ll.insertLast(root,38);
	ll.insertLast(root,36);
	ll.insertLast(root,68);
	root=ll.deleteItem(root,67);
	ll.traverse(root);
}
