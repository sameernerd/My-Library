#include<iostream>
#define MAX_SIZE 10
using namespace std;
int queue[MAX_SIZE];
int front=-1,rear=-1;
void push(int a){
	if(front==0&&rear==MAX_SIZE-1||front==rear+1){
		cout<<"Queue is full"<<endl;
	}
	else{
		if(front==-1){
			front=0;
			rear=0;
		}
		else if(rear==MAX_SIZE-1)rear=0;
		else rear++;
		queue[rear]=a;
	}
}
int pop(){
	int a=INT_MIN;
	if(front==-1){
		cout<<"Queue is empty ";
	}
	else{
		a=queue[front];
		if(front==rear){ //Popped the last element of the queue
			front=-1;
			rear=-1;
		}
		else if(front==MAX_SIZE-1)front=0; //When front is at the end
		else front++;
	}
	return a;
}
int main(){
	push(1);
	push(2);
	push(3);
	cout<<pop()<<" ";
	cout<<pop()<<" ";
	cout<<pop()<<" ";
	cout<<pop()<<" ";
}
