package lb.edu.aub.cmps;

import lb.edu.aub.exceptions.LocationNotFoundException;

import java.util.HashSet;
import java.util.Set;


public class XYCoordinates {
	//OVERVIEW: this class consists of two methods where we take the locations names as a set of strings 
	//and we return a set of Location as objects having get country longitude and lattitude in them
	//to be placed as locations on the map

	private Set<GoogleGeoLocation> locations;
	
	public XYCoordinates(Set<String> locations_names){
		locations= new HashSet<GoogleGeoLocation>();
		for(String location_name: locations_names){
			try {
				GoogleGeoLocation location= new GoogleGeoLocation(location_name);
				locations.add(location);
			} catch (LocationNotFoundException e) {
			}
		}
	}
	
	public XYCoordinates(Set<String> locations_names, String country){
		locations= new HashSet<GoogleGeoLocation>();
		for(String location_name: locations_names){
			try {
				GoogleGeoLocation location= new GoogleGeoLocation(location_name);
				if(location.getCountry().equals(country))
					locations.add(location);
			} catch (LocationNotFoundException e) {
			}
		}
	}

	public Set<GoogleGeoLocation> getLocations(){
		return locations;
	}
	

}