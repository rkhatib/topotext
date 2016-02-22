package lb.edu.aub.test;

import static org.junit.Assert.*;
import lb.edu.aub.cmps.GeoLocation;
import lb.edu.aub.exceptions.LocationNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

public class LocationTest 
{
	static GeoLocation location;
	static GeoLocation location2;
	static GeoLocation location3;

	@BeforeClass
	public static void setUpBeforeClass() throws LocationNotFoundException{
		 location= new GeoLocation("Beirut");
		 location2= new GeoLocation("paris");
	

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
		location3= new GeoLocation("bbbbbbbb");
	}

}
