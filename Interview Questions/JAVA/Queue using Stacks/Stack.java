
public class Stack {
	private int st[];
	private int top;
	private int MAX_SIZE;
	Stack(int n){
		MAX_SIZE=n;
		st=new int[MAX_SIZE];
		top=-1;
	}
	Stack(){
		MAX_SIZE=100000;
		st=new int[MAX_SIZE];
		top=-1;
	}
	public void push(int a){
		if(top==MAX_SIZE-1){
			System.out.println("Stack is full");
		}
		else{
			top++;
			st[top]=a;
		}
	}
	public int pop(){
		int num=Integer.MAX_VALUE;
		if(top==-1){
			//System.out.println("Stack is empty ");
		}
		else{
			num=st[top--]; 
		}
		return num;
	}
}
