
public class Main {
	public static void main(String[] args) {
		Queue q=new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}

}
