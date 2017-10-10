#include<iostream>
using namespace std;
class Stack;
Stack *root=NULL;
class Stack{
	int data;
	Stack *next;
	public:
		void push(int d){
			Stack *newNode=new Stack();
			newNode->data=d;
			newNode->next=root;
			root=newNode;
		}
		int pop(){
			int a=INT_MIN;
			if(root==NULL){
				cout<<"Stack is empty ";
			}
			else{
				a=root->data;
				root=root->next;
			}
			return a;
		}
};

int main(){
	Stack st;
	st.push(1);
	st.push(2);
	st.push(3);
	cout<<st.pop()<<" ";
	cout<<st.pop()<<" ";
	cout<<st.pop()<<" ";
	cout<<st.pop()<<" ";
	st.push(10);
	cout<<st.pop();
}
