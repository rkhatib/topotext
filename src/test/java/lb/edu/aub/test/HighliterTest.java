package lb.edu.aub.test;

import static org.junit.Assert.*;
import java.util.LinkedList;
import lb.edu.aub.cmps.HighlighterImplementation;
import lb.edu.aub.exceptions.LocationNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

public class HighliterTest 
{
	static String s;
	static LinkedList<Integer> neededIndeces;
	
	@BeforeClass
	public static void setUpBeforeClass() throws LocationNotFoundException{
		
		s= "This is our project, it is really awesome. We worked hard to get it done. This is a test class.";
		neededIndeces= new LinkedList<Integer>();
		neededIndeces.add(5);
		neededIndeces.add(24);
		neededIndeces.add(79);

	}
	@Test
	public void MyTest() 
	{
		
		assertEquals("Testing indeces collection", neededIndeces, HighlighterImplementation.allIndeces(s, "is"));
	
		
	}

}
