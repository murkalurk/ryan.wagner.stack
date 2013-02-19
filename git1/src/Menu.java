/**
 * Menu Class
 * 
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
			return "Q";
			return choiceString;}
	}