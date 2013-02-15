import java.io.*;

public class EvalPostfix{
	private PrintWriter writer;
	int prior, i, newN;
	Object topOb, topOb2;
	ObjectStack cool = new ObjectStack();
	InfixToPostfix infix = new InfixToPostfix(writer);
	public EvalPostfix(PrintWriter writer){
	this.writer = writer;}
	public void convPost(String input){
		for(i=0;i<input.length();i++){
			prior = infix.getOrder(input.charAt(i));
			doMath(input);}
			writer.println("Which equals: " + newN + "\n");
			newN = 0;}
	public void doMath(String input){
		if(prior == 6)
			cool.push(input.charAt(i));
		else
			{if(!cool.isEmpty())
				{topOb2 = Integer.parseInt(String.valueOf(cool.pop()));
				if(!cool.isEmpty())
					topOb = Integer.parseInt(String.valueOf(cool.pop()));}
			newN = doConv(input.charAt(i));
			cool.push(newN);}}
	public int doConv(Character conv){
		switch(conv){
			case '*': return (Integer)topOb * (Integer)topOb2;
			case '/': return (Integer)topOb / (Integer)topOb2;
			case '+': return (Integer)topOb + (Integer)topOb2;
			case '-': return (Integer)topOb - (Integer)topOb2;
			case '^': return (int)Math.pow((Integer)topOb, (Integer)topOb2);
			default: return 0;}}}