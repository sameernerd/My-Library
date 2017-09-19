#include<iostream>
using namespace std;

class LinkedList{
	public:
	class Node{
		public:
		int data;
		Node *next;
		Node *prev;
	};
	Node *insertLast(Node *root,int data){
		if(root==NULL){
			root=new Node();
			root->data=data;
			root->next=NULL;
			root->prev=NULL;
			return root;
		}
		Node *temp=root;
		while(temp->next!=NULL){
			temp=temp->next;
		}
		Node *newNode=new Node();
		newNode->data=data;
		newNode->prev=temp;
		newNode->next=NULL;
		temp->next=newNode;
		return root;
	}
	void traverse(Node *root){
		while(root!=NULL){
			cout<<root->data<<" ";
			root=root->next;
		}
	}
};
LinkedList::Node *root=NULL;

	LinkedList::Node *FindLargest(LinkedList::Node *root){ //For returning the address of largest node
		if(root==NULL)return NULL;
		int max=INT_MIN;
		LinkedList::Node *add;
		while(root!=NULL){
			if(root->data>max){
				max=root->data;
				add=root;
			}
			root=root->next;
		}
		return add;
	}
	int delete_largest(LinkedList::Node *r){
		LinkedList::Node *add=FindLargest(r);
		if(add==NULL)return -1; 
		if(add==r){
		    LinkedList::Node *save;
		    save=root;
			root=root->next;
			return save->data;
		}
		add->prev->next=add->next;
		return add->data;
	}
int main(){
	LinkedList ll;
	root=ll.insertLast(root,444);
	ll.insertLast(root,2);
	ll.insertLast(root,98);
	ll.insertLast(root,400);
	cout<<"Deleted "<<delete_largest(root)<<endl;
	ll.traverse(root);
}
