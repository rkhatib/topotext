package lb.edu.aub.cmps;

import java.util.Set;

public interface DrawMapInterface {

	/*
	 * requires: locations not null
	 * effects: creates an html file and automatically opens the browser and shows the map 
	 */
	public boolean drawMap(Set<String> locations);
	
	
	/*
	 * requires: locations not null, country not null
	 * effects: creates an html file and automatically opens the browser and shows the map in the specified country
	 */
	public boolean drawMapInCountry(Set<String> locations, String country);
}
