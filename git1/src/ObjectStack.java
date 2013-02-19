public class ObjectStack implements ObjectIn{
	private Object[] item;
	private int top;
	private int size;
	public ObjectStack() {
		size = 100;
		item = new Object[size];
		top = -1;
	}
	public ObjectStack(int max) {
		size = max;
		item = new Object[size];
		top = -1;
	}
	public boolean isEmpty() {
		return top == -1;
	}
	public boolean isFull() {
		return top == size-1;
	}
	public void clear() {
		item = new Object[size];
		top = -1;
	}
	public void push(Object x) {
		if (isFull()) {
			System.out.println("Push Runtime Error: Stack Overflow");
			System.exit(1);
		}
		item[++top] = x;
	}
	public Object pop() {
		if (isEmpty()) {
		System.out.println("Pop Runtime Error: Stack Underflow");
		System.exit(1);
		}
		Object temp = item[top];
		item[top--] = null;
		return temp;
	}
	public Object top() {
		if (isEmpty()) {
			System.out.println("Top Runtime Error: Stack Underflow");
			System.exit(1);
		}
		return item[top];
	}
}