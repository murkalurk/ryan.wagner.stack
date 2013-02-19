package csci210.wagner.ryan.stacklab;
import java.io.*;
import java.util.Scanner;
/**
 * Stack Lab Driver
 * @author Ryan Wagner
 * @author Student ID: 007222159
 * @version 1.0.2 - 2/18/2013
 */
public class Driver{
	/**
	 * Main constructor for class Driver.
	 * @param args
	 * @throws IOException		This program opens and closes files.
	 */
	public static void main(String[] args) throws IOException{
		String input, inString;
		PrintWriter writer = new PrintWriter(new FileWriter("csis.txt"));
		Scanner fileScan = new Scanner(new File("infix.txt"));
		IMenu menu = new Menu();
		InfixInterface infix = new InfixToPostfix(writer);
		EvalInterface evals = new EvalPostfix(writer);
		do{
			inString = fileScan.nextLine();
			input = menu.getLine(inString);
			writer.println("User input " + input);
			if(input != "Quit")
				{infix.inputRead(input);
				String postfix = infix.getPost();
				evals.convPost(postfix);}
		}while (input != "Quit");
		writer.close();
		fileScan.close();}}