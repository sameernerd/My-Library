#include<iostream>
#define MAX_SIZE 10
using namespace std;

int stack[MAX_SIZE];
int top=-1;
void push(int a){
	if(top==MAX_SIZE){
		cout<<"Stack is Full"<<endl;
	}
	else{
		top++;
		stack[top]=a;
	}
}
int pop(){
	int a=INT_MIN;
	if(top==-1){
		cout<<"Stack is empty "; 
	}
	else{
		a=stack[top--];
	}
	return a;
}
int main(){
	push(10);
	push(11);
	push(12);
	cout<<pop()<<endl;
	cout<<pop()<<endl;
	cout<<pop()<<endl;
	cout<<pop();
}
