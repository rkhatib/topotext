package lb.edu.aub.test;

import static org.junit.Assert.*;
import lb.edu.aub.cmps.Location;
import lb.edu.aub.exceptions.LocationNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

public class LocationTest 
{
	static Location location;
	static Location location2;
	static Location location3;

	@BeforeClass
	public static void setUpBeforeClass() throws LocationNotFoundException{
		 location= new Location("Beirut");
		 location2= new Location("paris");
	

	}
	@Test
	public void MyTest() throws LocationNotFoundException 
	{
		assertEquals(location.getCountry(), "Lebanon");
		assertEquals(location2.getCountry(), "France");
		
		
	}
	
	@Test ( expected = LocationNotFoundException.class )
	public void testLocationNotFoundException() throws LocationNotFoundException
	{
		location3= new Location("bbbbbbbb");
	}

}
