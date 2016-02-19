package lb.edu.aub.cmps;
import java.util.ArrayList;
import java.util.List;



public class Configuration
{
	//OVERVIEW
	//A singleton pattern designed class that stores the abbreviation of each part of speech in array lists 
	//and guarantees that there is only one instance of our configuration class
	public final  List<String> verbTags = new ArrayList<String>();
	public final  List<String> nounTags = new ArrayList<String>();
	public final  List<String> advTags = new ArrayList<String>();
	public final  List<String> adjTags = new ArrayList<String>();
	public final String noun = "noun";
	public final String verb = "verb";
	public final String adverb = "adverb";
	public final String adjective = "adjective";
	public static Configuration instance = new Configuration();
	

	
	private Configuration() 
	{
		verbTags.add("VB");
		verbTags.add("VBZ");
		verbTags.add("VBD");
		verbTags.add("VBG");
		verbTags.add("VBN");
		verbTags.add("VBP");
		nounTags.add("NN");
		nounTags.add("NNP");
		nounTags.add("NNS");
		nounTags.add("NNPS");
		advTags.add("RB");
		advTags.add("RBR");
		advTags.add("RBS");
		adjTags.add("JJ");
		adjTags.add("JJR");
		adjTags.add("JJS");
		
	}
	
	
}
