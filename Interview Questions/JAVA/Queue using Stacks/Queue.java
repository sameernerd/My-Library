//Implementation of Queue using stacks
public class Queue {
	private Stack st1=new Stack(10);
	private Stack st2=new Stack(10);
	
	public void enqueue(int a){
		st1.push(a);
	}
	public int dequeue(){
		int num,v;
		while((v=st1.pop())!=Integer.MAX_VALUE){
			st2.push(v);
		}
		num=st2.pop();
		while((v=st2.pop())!=Integer.MAX_VALUE){
			st1.push(v);
		}
		if(num==Integer.MAX_VALUE){
			System.out.println("Queue is Empty");
		}
		return num;
	}
}
