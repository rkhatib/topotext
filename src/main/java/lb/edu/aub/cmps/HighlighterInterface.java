package lb.edu.aub.cmps;

import java.util.LinkedList;

import javax.swing.text.JTextComponent;

public interface HighlighterInterface {

	//Highlights a single location throughout the text
	public void highlightLocation(JTextComponent textComp, String location);		
	
	//Highlights the distance specified around a certain location
	public void highlightWithDistance(JTextComponent textComp, String location, int index,
	int size, LinkedList<Integer> wordIndeces);
	
	//Returns the array of strings in the selected part
	public LinkedList<String> returnWords(JTextComponent textComp, int index, int size);
	
	//Move to the next location
	public void nextLocation(JTextComponent textComp, String location, int currentIndex,
			LinkedList<Integer> indexList, int size);

	//Move to the previous location
	public void previousLocation(JTextComponent textComp, String location, int currentIndex,
			LinkedList<Integer> indexList, int size);


}
