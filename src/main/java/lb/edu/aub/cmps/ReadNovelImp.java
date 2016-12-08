package lb.edu.aub.cmps;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;

public class ReadNovelImp implements ReadNovelInterface {
	private Set<String> locations;
	private String filePath;
	private HashMap<String, LinkedList<Integer>> locationIndices;

	/*
	 * returns: locations: HashMap of keyset locations and values list of
	 * indices.
	 */

	public ReadNovelImp(String fileName) {
		this.filePath = fileName;
		try {
			setLocations();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, LinkedList<Integer>> getLocationsWithIndeces() {
		String text;
		locationIndices = new HashMap<String, LinkedList<Integer>>();
		try {
			text = getText(filePath);
			String[] words = text.split("\\W+");

			for (String l : locations) {
				LinkedList<Integer> indecesInArray = new LinkedList<Integer>();
				if(l.split(" ").length==1){
					for (int i = 0; i < words.length; i++) {
						if (words[i].equalsIgnoreCase(l)) {
							indecesInArray.add(i);
						}
					}
				}
				else{
					
					for (int i = 0; i < words.length; i++) {
						if (words[i].equalsIgnoreCase(l.split(" ")[0]) && 
								words[i+1].equalsIgnoreCase(l.split(" ")[1])) {
							indecesInArray.add(i);
							i++;
						}
					}
				}
				locationIndices.put(l, indecesInArray);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return locationIndices;

	}

	
	/*
	 * requires: fileName not null effects: fills a map with the location in the
	 * string with their indices
	 */
	private void setLocations() throws FileNotFoundException {
		// Getting the classifier.
		AbstractSequenceClassifier<CoreLabel> classifier = getClassifier();
		// Creating a hashmap to contain the locations with the indices in which
		// they occur.
		locations = new TreeSet<String>();
		// Getting the text in the fileName as a string.
		String novel = getText(filePath);
		List<List<CoreLabel>> out = classifier.classify(novel);
		// Looping over all the words to find the locations, while keeping track
		// of their indices.
		for (List<CoreLabel> sentence : out) {
			LinkedList<CoreLabel> words = new LinkedList<CoreLabel>();
			for (CoreLabel word : sentence) {
				words.add(word);
			}
			for (int i = 0; i < words.size()-1; i++) {
				CoreLabel word = words.get(i);
				CoreLabel nextWord = words.get(i + 1);
				String geoLoc = word.word();
				if (word.get(CoreAnnotations.AnswerAnnotation.class).equals("LOCATION")) 
				{
					if (nextWord.get(CoreAnnotations.AnswerAnnotation.class).equals("LOCATION")) 
					{
						int j = i + 1;
						while (j < i + 5 && j< words.size()-1) 
						{
							if (words.get(j).get(CoreAnnotations.AnswerAnnotation.class).equals("LOCATION")) 
							{
								geoLoc += " " + words.get(j).word();
							}
							j++;
						}
						locations.add(geoLoc);
						i=j;
					}
					locations.add(geoLoc);
				}
			}
		}
	}

	/*
	 * Private method to get the classifier.
	 */
	private static AbstractSequenceClassifier<CoreLabel> getClassifier() {
		String serializedClassifier = "Files/english.all.3class.distsim.crf.ser.gz";
		AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier
				.getClassifierNoExceptions(serializedClassifier);
		return classifier;
	}

	/*
	 * Private method to get the text of the specified file name and return it
	 * as a string.
	 */
	private static String getText(String fileName) throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		String s = "";
		while (input.hasNextLine()) {
			s += input.nextLine() + " ";
		}
		input.close();
		return s;
	}

	public Set<String> getLocations() {
		return locations;
	}

	public HashMap<String, Integer> getLocationsWithWeights(){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		getLocationsWithIndeces();
		for(String loc : this.locationIndices.keySet()){
			map.put(loc, this.locationIndices.get(loc).size());
		}
		return map;
	}
}