package lb.edu.aub.cmps;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;



public class HighlighterImplementation implements HighlighterInterface{
	int currentLocation=0;


	public void highlightLocation(JTextComponent textComp, String location) {
		//Highlights a single location throughout the text
		Highlighter.HighlightPainter locationHighlighter= new MyHighlighPainter(Color.cyan);
		
		try{
			Highlighter highlighter= textComp.getHighlighter();
			highlighter.removeAllHighlights();
			Document doc = textComp.getDocument();
			String text = doc.getText(0, doc.getLength()).toUpperCase();
			int size= location.length();
			LinkedList<Integer> indeces= allIndeces(text, location.toUpperCase());
			for(int i=0; i<indeces.size(); i++){
				int index=indeces.get(i);
				highlighter.addHighlight(index, index+size, locationHighlighter);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

		public void highlightWithDistance(JTextComponent textComp, String location, int index,
			int size, LinkedList<Integer> wordIndeces ) {
		Highlighter.HighlightPainter cloudHighlighter= new MyHighlighPainter(new Color(211, 211, 211));
		Highlighter highlighter= textComp.getHighlighter();
		Document doc = textComp.getDocument();
		String text;
		try {
			text = doc.getText(0, doc.getLength()).toUpperCase();
			int txtSize= text.split(" ").length-1;
			location= location.toUpperCase();
			LinkedList<Integer> locationIndeces= allIndeces(text, location);
			Map<Integer, Integer> map= getMap(wordIndeces, locationIndeces);	
			int locationIndex= map.get(index);
			
			if(size>=index){
				highlighter.addHighlight(0, locationIndex, cloudHighlighter);
			}
			else if(size!=0){
				int i= locationIndex-2;
				int counterBefore=0;
	
				
				while(i>=0 && counterBefore<size){
					if(text.charAt(i)==' '){
						i--;
						counterBefore++;
					}
					else
						i--;
				}
				highlighter.addHighlight(i+2, locationIndex, cloudHighlighter);
			}
			if(locationIndeces.indexOf(index)+size>=txtSize && size!=0){
			
				highlighter.addHighlight(locationIndex+location.length(), text.length(), cloudHighlighter);
			}
			else if(size!=0){
				int start= locationIndex+location.length()+1;
				int i= start;
				int counterAfter=0;
	
				
				while(i<text.length() && counterAfter<size){
					if(text.charAt(i)==' '){
						i++;
						counterAfter++;
					}
					else
						i++;
				}
				highlighter.addHighlight(start-1, i-1, cloudHighlighter);
			}
			
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}


	public LinkedList<String> returnWords(JTextComponent textComp, int index,
			int size) {
		LinkedList<String> toReturn = new LinkedList<String>();
		Document doc = textComp.getDocument();
		String text="";
		String[] wordList;
		//LinkedList<String> returnList = new LinkedList<String>();
		try {
			text = doc.getText(0, doc.getLength());
			wordList= text.split(" ");
			
			//To avoid lower index out of bound
			if(index-size<0){
				for(int i=0; i<index; i++)
					toReturn.add(wordList[i]);
			}
			
			//If no lower index out of bound
			else{
				for(int i= index-size; i<index; i++){
					toReturn.add(wordList[i]);
				}
			}
			
			//To avoid upper index out of bound
			if(index+size>=wordList.length){
				for(int i= index+1; i<wordList.length; i++)
					toReturn.add(wordList[i]);
			}
			
			//If no upper index out of bound
			else{
				for(int i= index+1; i<=index+size; i++)
					toReturn.add(wordList[i]);
			}
			
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return toReturn;		
	}

///////////////////////
	public void nextLocation(JTextComponent textComp, String location, int currentIndex,
			LinkedList<Integer> indexList, int size) {
		Highlighter highlighter= textComp.getHighlighter();
		highlighter.removeAllHighlights();
		highlightLocation(textComp, location);
		int index= indexList.indexOf(currentIndex);

		if(index== indexList.size()-1){
			   JOptionPane.showMessageDialog(null, "No more instances of this location");
		}
		else{
			index++;
			setCurrentLocation(indexList.get(index));
			highlightWithDistance(textComp, location, indexList.get(index), size, indexList);
		}
		
	}

//////////////////
	public void previousLocation(JTextComponent textComp, String location, int currentIndex,
			LinkedList<Integer> indexList, int size) {
		Highlighter highlighter= textComp.getHighlighter();
		highlighter.removeAllHighlights();
		highlightLocation(textComp, location);
		int index= indexList.indexOf(currentIndex);

		if(index== 0){
			   JOptionPane.showMessageDialog(null, "No more instances of this location");
		}
		else if(index< indexList.size()){
			index--;
			setCurrentLocation(indexList.get(index));
			//posLabel.setText(""+index);
			highlightWithDistance(textComp, location, indexList.get(index), size, indexList);
		}
		else{
			index= indexList.size()-1;
			setCurrentLocation(indexList.get(index));
		//	posLabel.setText(""+index);
			highlightWithDistance(textComp, location, indexList.get(index), size, indexList);
		}
	}
/////////////////////	
	public static LinkedList<Integer> allIndeces(String s, String word){
		LinkedList<Integer> positions = new LinkedList<Integer>();
		Pattern p = Pattern.compile(" "+word.toUpperCase());
		Pattern p1 = Pattern.compile("\n"+word.toUpperCase());
		Pattern p2 = Pattern.compile("\t"+word.toUpperCase());
		Matcher m = p.matcher(" "+s.toUpperCase());
		Matcher m1 = p1.matcher(" "+s.toUpperCase());
		Matcher m2 = p2.matcher(" "+s.toUpperCase());
		
		while (m.find()) {
		   positions.add(m.start());
		}
		
		while (m1.find()) {
			   positions.add(m1.start());
		}
	
		while (m2.find()) {
			   positions.add(m2.start());
		}
		return positions;
	}
	////////////////////
	public Map<Integer, Integer> getMap(LinkedList<Integer> wordIndex, LinkedList<Integer> occurances){
		System.out.println("word index "+wordIndex+"\noccurances "+occurances);
		Map<Integer, Integer> map= new HashMap<Integer, Integer>();
		for(int i=0; i<wordIndex.size(); i++){
			
			map.put(wordIndex.get(i), occurances.get(i));
		}
		return map;
	}
	
	
	public void setCurrentLocation(int newLocation){
		currentLocation= newLocation;
	}




}
