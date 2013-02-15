import java.io.*;
import java.util.Scanner;
public class Driver{
	public static void main(String[] args) throws IOException{
		String input, inString;
		PrintWriter writer = new PrintWriter(new FileWriter("csis.txt"));
		Scanner fileScan = new Scanner(new File("infix.txt"));
		Menu menu = new Menu();
		InfixToPostfix infix = new InfixToPostfix(writer);
		EvalPostfix eval = new EvalPostfix(writer);
		do{
			inString = fileScan.nextLine();
			input = menu.getLine(inString);
			writer.println("User input " + input);
			infix.inputRead(input);
			String postfix = infix.getPost();
			eval.convPost(postfix);
		}while (input != "Quit");
		writer.close();
		fileScan.close();}}