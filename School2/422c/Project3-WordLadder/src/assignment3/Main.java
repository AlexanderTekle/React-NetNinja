r/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Fall 2018
 */


package assignment3;
import java.util.*;
import java.io.*;

public class Main {
	
	// static variables and constants only here.
	
	public static void main(String[] args) throws Exception {
		
		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file, for student testing and grading only
		// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default input from Stdin
			ps = System.out;			// default output to Stdout
		}
		initialize();
		
		// TODO methods to read in words, output ladder
	}
	
	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it 
		// only once at the start of main.
	}
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of Strings containing start word and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		String input = keyboard.nextLine();
		
		if (CheckInput.quit(input))
			return new ArrayList<String>();
		
		else {
			if (CheckInput.valid(input)) {
				String words[] = input.split(" ");
				ArrayList<String> ret = new ArrayList<String>();
				ret.add(words[0]);
				ret.add(words[1]);
				return ret;
			} 
		}
		// TO DO
		return null;
	}
	
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		
		// Returned list should be ordered start to end.  Include start and end.
		// If ladder is empty, return list with just start and end.
		// TODO some code
		Set<String> dict = makeDictionary();
		// TODO more code
		
		return null; // replace this line later with real return
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		
		// TODO some code
		Set<String> dict = makeDictionary();
		Queue<String> words = new LinkedList<String>();
		words.add(start);
		ArrayList<String> ret = new ArrayList<String>();
		ret.add(start);
		// TODO more code
		
		while (!words.isEmpty()) {
			String current = words.poll();
			
			for (String s : dict) {
				if (isAdjacent(start, s)) {
					words.add(s);
					dict.remove(s);
					ret.add(s);
					
					if (s.equals(end)) {
						ret.add(s);
						ret.add(end);
						return ret;
					}
				}
			}
		}
		
		return null; // replace this line later with real return
	}
    
	
	public static void printLadder(ArrayList<String> ladder) {
		for (int i=0;i<ladder.size();i++) {
			System.out.println(ladder.get(i));
		}
		
	}
	// TODO
	// Other private static methods here
	
	private static boolean isAdjacent(String one, String two) {
	    int length = one.length(); 
	    int count = 0;  
	    
	    char first[] = one.toCharArray();
	    char second[] = two.toCharArray();
	    
	    for (int i = 0; i < length; i++) {
	        if (first[i] != second[i]) 
	        		count++; 
	        if (count > 1) 
	        		return false; 
	    } 
	    return (count == 1);
	}


	/* Do not modify makeDictionary */
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
}
