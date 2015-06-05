package lb.edu.aub.cmps;
import java.util.HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
//import edu.stanford.nlp.tagger.maxent.MaxentTagger;
public class PartsOfSpeechImp implements PartsOfSpeechInterface
{		
		//OVERVIEW
		//This class returns the words of the specified parts of speech by the user
		public LinkedList<String> promptedPartsOfSpeech(LinkedList<String> text, List<String> partsOfSpeech)
		{
			/*
			 * requires:A linked list of strings which are part of the selected text
			 * 			A list of the prompted parts of speech from the user
			 * 			Both data structures are required not be null
			 * modifies:text
			 * effects:It tags the text by its part of speech	  
			 * returns:A new linked list containing the Strings with parts of speech similar to what the user prompted.
			 * 		   Example: text={shadia is}
			 * 					partsOfSpeech=[verb]
			 * 					returns: {is}
			 */
			LinkedList<String> neededWords = new LinkedList<String>();
			Map<String, String> mapWordTag = tagList(text);
			for( int i=0; i< partsOfSpeech.size(); i++ )
			{
				partsOfSpeech.set(i, partsOfSpeech.get(i).toLowerCase());
			}
			for(String word: mapWordTag.keySet()) 
			{
				String tag = mapWordTag.get(word).trim();
				if(Configuration.instance.nounTags.contains(tag) && partsOfSpeech.contains(Configuration.instance.noun)) 
				{
					neededWords.add(word);
				}
				if(Configuration.instance.verbTags.contains(tag) && partsOfSpeech.contains(Configuration.instance.verb))
				{
					neededWords.add(word);
				}
				if(Configuration.instance.adjTags.contains(tag) && partsOfSpeech.contains(Configuration.instance.adjective))
				{
					neededWords.add(word);
				}
				if(Configuration.instance.advTags.contains(tag) && partsOfSpeech.contains(Configuration.instance.adverb)) 
				{
					neededWords.add(word);
				}
			}
			
			return neededWords;
		}
		private Map<String, String> tagList(LinkedList<String> text)
		{
			/*
			 * requires: A linked list of strings which are of the selected text not equal to null
			 * modifies: text
			 * effects: It tags the text by its parts of speech and stores the words 
			 * returns: a map with (word, tag) 
			 */
			MaxentTagger tagger = new MaxentTagger("Files/english-left3words-distsim.tagger");
			Map<String, String> mapWordTag = new HashMap<String, String>();
			for(String word: text)
			{
				try{
				mapWordTag.put(word, tagger.tagString(word).split("_")[1]);
				}
				catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
			return mapWordTag;
		}
			
}