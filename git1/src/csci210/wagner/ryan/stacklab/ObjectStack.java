package csci210.wagner.ryan.stacklab;
/**
 * 
 * ObjectStack class.
 * @author Ryan Wagner
 * @author Student ID: 007222159
 * @version 1.0.2 - 2/18/2013
 */
public class ObjectStack implements ObjectIn{
	private Object[] item;
	private int top;
	private int size;
	/**
	 * Default constructor for ObjectStack, allows 100 items in the stack.
	 */
	public ObjectStack() {
		size = 100;
		item = new Object[size];
		top = -1;
	}
	/**
	 * Variable size ObjectStack constructor.
	 * @param max		Takes in a maximum size for the stack.
	 */
	public ObjectStack(int max) {
		size = max;
		item = new Object[size];
		top = -1;
	}
	/**
	 * Returns true if ObjectStack is empty.
	 * @return			Returns true if top == -1.
	 */
	public boolean isEmpty() {
		return top == -1;
	}
	/**
	 * Returns true if ObjectStack is full.
	 * @return			Returns true if top == size - 1.
	 */
	public boolean isFull() {
		return top == size-1;
	}
	/**
	 * Clears the stack.
	 */
	public void clear() {
		item = new Object[size];
		top = -1;
	}
	/**
	 * Pushes the designated item to the top of the Stack, incrementing the top variable by 1.
	 * @param x			Takes in the designated object to the stack.
	 */
	public void push(Object x) {
		if (isFull()) {
			System.out.println("Push Runtime Error: Stack Overflow");
			System.exit(1);
		}
		item[++top] = x;
	}
	/**
	 * Pops the designated item from the top of the stack, decrementing the stack by 1.
	 * @return			Returns the temporary variable to the calling function.
	 */
	public Object pop() {
		if (isEmpty()) {
		System.out.println("Pop Runtime Error: Stack Underflow");
		System.exit(1);
		}
		Object temp = item[top];
		item[top--] = null;
		return temp;
	}
	/**
	 * Finds the item at the top of the stack.
	 * @return			Returns the item at the top of the stack.
	 */
	public Object top() {
		if (isEmpty()) {
			System.out.println("Top Runtime Error: Stack Underflow");
			System.exit(1);
		}
		return item[top];
	}
}