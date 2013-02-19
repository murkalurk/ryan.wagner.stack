package csci210.wagner.ryan.stacklab;
import java.io.*;
/**
 * Infix Conversion Class
 * @author Ryan Wagner
 * @author Student ID: 007222159
 * @version 1.0.2 - 2/18/2013
 */
public class InfixToPostfix implements InfixInterface{
	private PrintWriter writer;
	private int prior, prior2, i, j, k;
	private String postfix = "", post2, post3;
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
		if(post3 != "Error!")
			jCheck();
		post3 = "";
		postfix = "";}
	/**
	 * Retrieves the priority of the current character and checks operators to find erroneous input.
	 * @param input			Reads the user's input.
	 */
	public void doWork(String input){
			prior = getOrder(input.charAt(i));
			if(prior == 1 || prior == 2 || prior == 3)
				operCheck(input);
			else if(prior == 6 && i > 0)
				intCheck(input);}
	/**
	 * Initializes prior2 to the value of the item at the top of the ObjectStack.
	 */
	public void getObject(){
		myObj = inS.top();
		prior2 = getOrder((Character)myObj);}
	/**
	 * Checks if there are too many operators.
	 * @param input			Reads the user's input.
	 */
	public void operCheck(String input){
		prior2 = getOrder(input.charAt(i-1));
		if(prior2 == 1 || prior2 == 2 || prior2 == 3)
				{writer.println("Too many operators!\n");
				postfix = "Error!";
				post3 = postfix;
				postfix = "";}}
	/**
	 * Check for adjacent integers.
	 * @param input			Reads the user's input.
	 */
	public void intCheck(String input){
		prior2 = getOrder(input.charAt(i-1));
		if(prior2 == 6)
		{writer.println("One digit at a time, please!\n");
		post3 = "Error!";
		post2 = "Error!";}}
	/**
	 * Checks if the parens match.  If not, throws error messages and prevents the Evaluation class from executing.
	 */
	public void jCheck(){
		if(j > 0)
			openP();
		else if(j < 0)
			closeP();
		else if(k == 1)
			exitO();
		else
			normO();}
	/**
	 * Actions executed when there are too many open parens.
	 */
	public void openP(){
		writer.println("Too many open parens!\n");
		j = 0;
		postfix = "Error!";
		post2 = postfix;
		postfix = "";}
	/**
	 * Actions executed when there are too many close parens.
	 */
	public void closeP(){
		writer.println("Too many close parens!\n");
		j = 0;
		postfix = "Error!";
		post2 = postfix;
		postfix = "";}
	/**
	 * Actions executed when the input file reaches an exit signal.
	 */
	public void exitO(){
		writer.println("Exit.");
		post2 = "Error!";}
	/**
	 * Actions executed when there is nothing wrong in the program.
	 */
	public void normO(){
		post2 = postfix;
		writer.println(postfix);
		postfix = "";}
	/**
	 * Checks the assigned priority of the current character and decides what to do.
	 * @param input			Reads the user's input.
	 */
	public void compPrior(String input){
		if(prior == 6)
			postfix = postfix + input.charAt(i);
		else if(prior == 5)
			k = 1;
		else if(prior == 0)
			{inS.push(input.charAt(i));
			j++;}
		else if(prior == 4)
			{j--;
			closeParen();}
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
	 * If the priority of the current character is greater than that at the top of the stack, push onto the stack.
	 * Otherwise, execute popCond().
	 * If the Stack is empty, push onto the stack.
	 * @param input			Reads the user's input.
	 */
	public void popNpush(String input){
		if(!inS.isEmpty())
				{getObject();
			if(prior > prior2)
				inS.push(input.charAt(i));
			else
				{popCond(input);}}
		else
			inS.push(input.charAt(i));}
	/**
	 * While the current character is of lower or equal priority to the top of the stack, pop the stack.
	 * When this stops being true, push the current character onto the stack.
	 * @param input			Reads the user's input.
	 */
	public void popCond(String input){
		while(!inS.isEmpty() && prior <= prior2)
		{getObject();
		if(prior <= prior2)
			postfix = postfix + inS.pop();}
	inS.push(input.charAt(i));
	}
	/**
	 * Computes the priority of the character assigned to orderGet.
	 * @param orderGet		Reads the assigned character.
	 * @return				Returns the priority.
	 */
	public int getOrder(char orderGet){
		switch(orderGet){
			case 'Q': return 5;
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
		if(post3 != "Error!")
			return post2;
		else
			return post3;}}