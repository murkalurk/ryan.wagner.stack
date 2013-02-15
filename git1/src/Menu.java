public class Menu{

	public Menu(){
	}
	public String getLine(String choiceString){
		choiceString = choiceString.replaceAll(" ", "");
		if(choiceString.charAt(0) == 'q'
		|| choiceString.charAt(0) == 'Q')
			return "Quit";
			return choiceString;}}