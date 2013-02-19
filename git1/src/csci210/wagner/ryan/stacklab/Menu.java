package csci210.wagner.ryan.stacklab;
/**
 * Menu Class
 * @author Ryan Wagner
 * @author Student ID: 007222159
 * @version 1.0.2 - 2/18/2013
 */
public class Menu extends Driver implements IMenu{
	/**
	 * Empty constructor for the Menu class.
	 */
	public Menu(){}
	/**
	 * 
	 * @param choiceString		Takes in the input as a String.
	 * @return					Returns the String if the first character is not 'Q.'
	 */
	public String getLine(String choiceString){
		choiceString = choiceString.replaceAll(" ", "");
		if(choiceString.charAt(0) == 'q'
		|| choiceString.charAt(0) == 'Q')
			return "Quit";
			return choiceString;}}