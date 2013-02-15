import java.io.*;
/**
 * Infix Conversion Class
 * @author Muzu
 * @version 1.0 - 2/15/2013
 */
public class InfixToPostfix{
	private PrintWriter writer;
	private int prior, prior2, i;
	private String postfix = "", post2;
	private ObjectStack inS = new ObjectStack();
	private Object myObj;
	/**
	 * Class constructor initializes PrintWriter.
	 * @param writer		Writes all output to file "csis.txt"
	 */
	public InfixToPostfix(PrintWriter writer){
		this.writer = writer;}
	/**
	 * Reads input and decides how to use it.
	 * @param input			Reads the user's input.
	 */
	public void inputRead(String input){
		writer.print("Output is: ");
		for(i=0;i<input.length();i++){
		doWork(input);
		compPrior(input);}
		while(!inS.isEmpty())
			postfix = postfix + inS.pop();
		post2 = postfix;
		writer.println(postfix);
		postfix = "";}
	/**
	 * Retrieves the priority of the current character.
	 * @param input			Reads the user's input.
	 */
	public void doWork(String input){
			prior = getOrder(input.charAt(i));}
	/**
	 * Initializes prior2 to the value of the item at the top of the ObjectStack.
	 */
	public void getObject(){
		myObj = inS.top();
		prior2 = getOrder((Character)myObj);}
	/**
	 * Checks the assigned priority of the current character and decides what to do.
	 * @param input			Reads the user's input.
	 */
	public void compPrior(String input){
		if(prior == 6)
			postfix = postfix + input.charAt(i);
		else if(prior == 0)
			inS.push(input.charAt(i));
		else if(prior == 4)
			{closeParen();}
		else 
			popNpush(input);}
	/**
	 * If the current character is close paren (special case) decides how to use it.
	 */
	public void closeParen(){
		while(!inS.isEmpty())
			{getObject();
			if(prior2 != 0)
				postfix = postfix + inS.pop();
			else
				{inS.pop();
				if(prior2 != 0)
					inS.pop();
				else
					break;}}}
	/**
	 * Normal popping/pushing functions.
	 * @param input			Reads the user's input.
	 */
	public void popNpush(String input){
		if(!inS.isEmpty())
				{getObject();
			if(prior > prior2)
				inS.push(input.charAt(i));
			else
				{while(!inS.isEmpty() && prior <= prior2)
					{getObject();
					if(prior <= prior2)
						postfix = postfix + inS.pop();}
				inS.push(input.charAt(i));}}
			else
				inS.push(input.charAt(i));}
	/**
	 * Computes the priority of the character assigned to orderGet.
	 * @param orderGet		Reads the assigned character.
	 * @return				Returns the priority.
	 */
	public int getOrder(char orderGet){
		switch(orderGet){
			case ')':return 4;
			case '^':return 3;
			case '*':case '/':return 2;
			case '+':case '-':return 1;
			case '(':return 0;
			default:return 6;}}
	/**
	 * Assigns a value to post2 to be used through the Driver by the Postfix Evaluation Driver.
	 * @return				Returns the postfix string as post2.
	 */
	public String getPost(){
		return post2;
	}}