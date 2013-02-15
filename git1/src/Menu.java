/**
 * Menu Class
 * @author Ryan Wagner
 * @version 1.0.1 - 2/15/2013
 */
public class Menu{
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