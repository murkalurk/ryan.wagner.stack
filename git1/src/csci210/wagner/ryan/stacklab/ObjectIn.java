package csci210.wagner.ryan.stacklab;
/**
 * Interface for ObjectStack.
 * @author Ryan Wagner
 * @author Student: 007222159
 * @version 1.0.2 2/18/2013
 */
public interface ObjectIn {
	/**
	 * Returns true if the Stack is empty.
	 * @return		Returns true if position = -1
	 */
	public boolean isEmpty();
	/**
	 * Returns true if the Stack is full.
	 * @return		Returns true if position = size
	 */
	public boolean isFull();
	/**
	 * Clears the Stack.
	 */
	public void clear();
	/**
	 * Pushes an Object onto the Stack.
	 * @param x		Takes in the Object as variable x.
	 */
	public void push(Object x);
	/**
	 * Pops the item from the top of the Stack.
	 * @return		Returns the item at the top of the Stack.
	 */
	public Object pop();
	/**
	 * Checks the item at the top of the Stack.
	 * @return		Returns the item at the top of the Stack without popping.
	 */
	public Object top();
}
