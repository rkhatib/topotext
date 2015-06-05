
package lb.edu.aub.test;

import static org.junit.Assert.*;

import java.util.LinkedList;


import lb.edu.aub.cmps.PartsOfSpeechImp;

import org.junit.Test;

public class PosTest 
{

	@Test
	public void Test() 
	{
		PartsOfSpeechImp pi=new PartsOfSpeechImp();
		LinkedList<String> text=new LinkedList<String>();
		text.add("is");
		text.add("shadia");
		text.add("happy");
		text.add("very");
		LinkedList<String> pos=new LinkedList<String>();
		pos.add("noun");
		pos.add("verb");
		pos.add("adverb");
		pos.add("adjective");
		
		LinkedList<String> noun=new LinkedList<String>();
		LinkedList<String> verb=new LinkedList<String>();
		LinkedList<String> adjective=new LinkedList<String>();
		LinkedList<String> adverb=new LinkedList<String>();
		
		noun.add("noun");
		verb.add("verb");
		adverb.add("adverb");
		adjective.add("adjective");
		
		assertEquals("needed parts of speech", "shadia",pi.promptedPartsOfSpeech(text, noun).get(0));
		assertEquals("needed parts of speech", "is",pi.promptedPartsOfSpeech(text, verb).get(0));
		assertEquals("needed parts of speech", "very",pi.promptedPartsOfSpeech(text, adverb).get(0));
		assertEquals("needed parts of speech", "happy",pi.promptedPartsOfSpeech(text, adjective).get(0));
		 
		
	}

}