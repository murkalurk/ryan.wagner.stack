import java.io.*;
public class InfixToPostfix{
	private PrintWriter writer;
	private int prior, prior2, i;
	private String postfix = "", post2;
	private ObjectStack inS = new ObjectStack();
	private Object myObj;
	public InfixToPostfix(PrintWriter writer){
		this.writer = writer;}
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
	public void doWork(String input){
			prior = getOrder(input.charAt(i));}
	public void getObject(){
		myObj = inS.top();
		prior2 = getOrder((Character)myObj);}
	public void compPrior(String input){
		if(prior == 6)
			postfix = postfix + input.charAt(i);
		else if(prior == 0)
			inS.push(input.charAt(i));
		else if(prior == 4)
			{closeParen();}
		else 
			popNpush(input);}
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
	public int getOrder(char orderGet){
		switch(orderGet){
			case ')':return 4;
			case '^':return 3;
			case '*':case '/':return 2;
			case '+':case '-':return 1;
			case '(':return 0;
			default:return 6;}}
	public String getPost(){
		return post2;
	}}