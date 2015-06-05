package lb.edu.aub.cmps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class UninterstingWords {

	public static LinkedList<String> uninterstingWords(){
	
		LinkedList<String> words= new LinkedList<String>();
		try {
			
			Scanner sc= new Scanner(new File("Files/uninterestingWords.txt"));
			while(sc.hasNextLine()){
				words.add(sc.nextLine());
			
			}
			sc.close();
		} catch (FileNotFoundException e) {
		}
		
		return words;
	}
}
