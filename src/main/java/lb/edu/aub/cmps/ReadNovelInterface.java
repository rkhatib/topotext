package lb.edu.aub.cmps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public interface ReadNovelInterface {
	
	/*
	 * returns: locations: HashMap of keyset locations and values list of indices.
	 */
	public HashMap<String, LinkedList<Integer>> getLocationsWithIndeces();
	
	/*
	 * returns: locations: HashMap of keyset locations and values list of indices.
	 */
	public Set<String> getLocations();
	
	public HashMap<String, Integer> getLocationsWithWeights();
}
