package lb.edu.aub.test;


import org.junit.Test;
import java.util.LinkedList;
import junit.framework.TestCase;
import lb.edu.aub.cmps.CountFrequency;
import lb.edu.aub.cmps.CountFrequencyImp;

public class GenerateCloudTest extends TestCase 
{
	static LinkedList<String> locations;
	
	@Test

	public void testingMethod()
	{
		locations= new LinkedList<String>();

		locations.add("Paris");
		locations.add("USA");
		locations.add("London");
		locations.add("France");
		locations.add("Beirut");
		locations.add("Tyre");
		locations.add("Paris");
		locations.add("Orleans");
		locations.add("Beirut");
		locations.add("Paris");
		locations.add("Paris");
		locations.add("London");
		locations.add("France");
		locations.add("Beirut");
		locations.add("Tyre");
		locations.add("Paris");
		locations.add("Orleans");
		locations.add("Beirut");
		locations.add("Paris");

		CountFrequency a = new CountFrequencyImp(locations);

		assertEquals("testing the method most frequent cloud",a.MFW(),"Paris");
		assertEquals("testing the method least frequent cloud", a.LFW(),"USA");
		
		assertNotSame("testing the method most frequent cloud",a.MFW(),"Beirut");
		assertNotSame("testing the method least frequent cloud", a.LFW(),"Beirut");
	}
	
}
