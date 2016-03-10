package lb.edu.aub.test;

import static org.junit.Assert.*;
import lb.edu.aub.cmps.GoogleGeoLocation;
import lb.edu.aub.exceptions.LocationNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

public class LocationTest 
{
	static GoogleGeoLocation location;
	static GoogleGeoLocation location2;
	static GoogleGeoLocation location3;

	@BeforeClass
	public static void setUpBeforeClass() throws LocationNotFoundException{
		 location= new GoogleGeoLocation("Beirut");
		 location2= new GoogleGeoLocation("paris");
	

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
		location3= new GoogleGeoLocation("bbbbbbbb");
	}

}
