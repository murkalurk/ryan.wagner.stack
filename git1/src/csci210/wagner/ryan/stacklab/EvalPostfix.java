package csci210.wagner.ryan.stacklab;
import java.io.*;
/**
 * Postfix expression evaluation Class.
 * @author Ryan Wagner
 * @author Student ID: 007222159
 * @version 1.0.2 - 2/18/2013
 */
public class EvalPostfix implements EvalInterface{
	private PrintWriter writer;
	int prior, i, newN;
	Object topOb, topOb2;
	ObjectStack cool = new ObjectStack();
	InfixToPostfix infix = new InfixToPostfix(writer);
	/**
	 * Class constructor initializes PrintWriter.
	 * @param writer		Writes all output to file "csis.txt".
	 */
	public EvalPostfix(PrintWriter writer){
	this.writer = writer;}
	/**
	 * Reads the postfix expression and decides how to use it.
	 * @param input			Reads the user's input.
	 */
	public void convPost(String input){
		if(input != "Error!")
		{for(i=0;i<input.length();i++){
			prior = infix.getOrder(input.charAt(i));
			doMath(input);}
			writer.println("Which equals: " + newN + "\n");
			newN = 0;}}
	/**
	 * If an operand is found, push it onto the stack, else pop the stack twice,
	 * do math on the top two items, and push the result back onto the stack.
	 * @param input			Reads the user's input.
	 */
	public void doMath(String input){
		if(prior == 6)
			cool.push(input.charAt(i));
		else
			{if(!cool.isEmpty())
				{popCool();}
			newN = doConv(input.charAt(i));
			cool.push(newN);}}
	/**
	 * Pops the top two values in the stack.
	 */
	public void popCool(){
		topOb2 = Integer.parseInt(String.valueOf(cool.pop()));
		if(!cool.isEmpty())
			topOb = Integer.parseInt(String.valueOf(cool.pop()));}
	/**
	 * Do math on the popped values based on the chosen operator.
	 * @param conv			Takes the operator as input.
	 * @return				Returns the resultant int value to be pushed onto the stack.
	 */
	public int doConv(Character conv){
		switch(conv){
			case '*': return (Integer)topOb * (Integer)topOb2;
			case '/': return (Integer)topOb / (Integer)topOb2;
			case '+': return (Integer)topOb + (Integer)topOb2;
			case '-': return (Integer)topOb - (Integer)topOb2;
			case '^': return (int)Math.pow((Integer)topOb, (Integer)topOb2);
			default: return 0;}}}