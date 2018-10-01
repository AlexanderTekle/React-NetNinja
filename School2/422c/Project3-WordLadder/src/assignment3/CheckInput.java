package assignment3;

public class CheckInput {
	
	public static boolean quit(String s) {
		return (s.equals("/quit"));
	}
	
	public static boolean valid(String s) {
		if (s.indexOf(" ") <=0)
			return false;
		String[] words = s.split(" ");
		if (words.length != 2)
			return false;
		if (words[0].length() <= 1 || words[1].length() <= 1)
			return false;
		return true;
	}
}
