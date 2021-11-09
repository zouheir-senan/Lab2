package huffmanCoding;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanCoding {
	
	public class Node{
		private int frequency ;
		private char character ;
		public int getFrequency() {
			return frequency;
		}
		public void setFrequency(int frequency) {
			this.frequency = frequency;
		}
		public char getCharacter() {
			return character;
		}
		public void setCharacter(char character) {
			this.character = character;
		}
		
		
		}
	
	static final boolean readFoemeFile =false ;
	static final boolean nevTextBasedOnOldOne=false;
	
	static PriorityQueue<Node> nodes = new PriorityQueue<>();
	static HashMap<Character, String> codes = new HashMap<>();
	static String text = "";
	static String encoded = "";
	static String decoded= "";
	static int ASCII[] = new int[128];
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = (readFoemeFile) ? new Scanner(new File("input.txt")) : new Scanner(System.in);
		int decision = 1;
		while (decision !=-1) {
			if(handlingDecision(scanner,decision)) continue;
			decision = consoleMenu(scanner);
		}
	}
	private static boolean handlingDecision(Scanner scanner, int decision) {
		switch (decision) {
		case 1: {
			if(handleNevText(scanner))return true; 
			break;
		}
		case 2: {
			if(handleEncodingNevText(scanner))return true; 
			break;
		}
		case 3: {
			handleDecodingNevText(scanner); 
			break;
		}
		case -1: {
			 
			return false;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + decision);
		}
		return false;
		
		
	}

	private static int consoleMenu(Scanner scanner) {
		int decision ;
		System.out.println("\n----Menu-----\n"
				+ "--- [-1] to exit \n"
				+ "--- [ 1] to enter new text\n"
				+ "--- [ 2] to encode a text\n"
				+ "--- [ 3] to decode a text");
		decision = Integer.parseInt(scanner.nextLine());
		if(readFoemeFile)
			System.out.println("Decision: "+ decision+"\n---End of Menu ");
		return decision;
	}
	private static void handleDecodingNevText(Scanner scanner) {
		System.out.println("Enter the text to decode:");
		encoded = scanner.nextLine();
		System.out.println("Text to Decode: "+ encoded);
		decodeText();
	}
	private static void decodeText() {
		// TODO Auto-generated method stub
		
	}
	private static boolean handleEncodingNevText(Scanner scanner) {
		System.out.println("Enter the text to encode :");
		text = scanner.nextLine();
		System.out.println("Text to Eecode: "+text);
		
		if(!IsSameCharacterSet()){
			System.out.println("Not Vaild input");
			text = "";
			return false;
		}
		decodeText();
		return false;
	}

	private static boolean IsSameCharacterSet() {
		// TODO Auto-generated method stub
		return false;
	}
	private static boolean handleNevText(Scanner scanner) {
		// TODO Auto-generated method stub
		return false;
	}

}
