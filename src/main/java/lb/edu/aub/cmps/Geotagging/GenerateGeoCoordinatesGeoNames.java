package lb.edu.aub.cmps.Geotagging;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import lb.edu.aub.cmps.GeoLocationWithOptions;

import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

//OVERVIEW: this class will generate an array of GeoLocationWithOptions from an array of location_name
public class GenerateGeoCoordinatesGeoNames implements GenerateGeoCoordinates {

	public GeoLocationWithOptions[] generateGeoLocations(HashMap<String, Integer> name_weight_map) {
		WebService.setUserName("julia94"); // add your username here
		ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
		
		List<GeoLocationWithOptions> geo_locations = new LinkedList<GeoLocationWithOptions>();

		
		for(String location_name: name_weight_map.keySet()){

			searchCriteria.setQ(location_name);
			GeoLocationWithOptions geo_location = new GeoLocationWithOptions(location_name);
			geo_location.setWeight(name_weight_map.get(location_name));
			Set<String> countries = new HashSet<String>();
			ToponymSearchResult searchResult;
			try {
				searchResult = WebService.search(searchCriteria);
				for (Toponym toponym : searchResult.getToponyms()) {
					
					if(toponym != null && toponym.getCountryName()!= null && !countries.contains(toponym.getCountryName().toLowerCase()) && toponym.getName().equals(location_name)){
												
						countries.add(toponym.getCountryName().toLowerCase());
						geo_location.add(location_name, toponym.getLatitude(), toponym.getLongitude(), toponym.getCountryName(), "",name_weight_map.get(location_name));
						
					}
					
				}
				geo_locations.add(geo_location);
			} catch (Exception e) {
				e.printStackTrace();
				geo_locations.add(null);
			}
		}	
		GeoLocationWithOptions[] geo_locations_array = new GeoLocationWithOptions[geo_locations.size()];
		int i = 0;
		for(GeoLocationWithOptions loc: geo_locations){
			geo_locations_array[i] = loc; i++;
		}
		return geo_locations_array;
	}
	
	public static GeoLocationWithOptions[] generateGeoLocationss(HashMap<String, Integer> name_weight_map) {
		WebService.setUserName("julia94"); // add your username here
		ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
		
		List<GeoLocationWithOptions> geo_locations = new LinkedList<GeoLocationWithOptions>();

		
		for(String location_name: name_weight_map.keySet()){

			searchCriteria.setQ(location_name);
			GeoLocationWithOptions geo_location = new GeoLocationWithOptions(location_name);
			geo_location.setWeight(name_weight_map.get(location_name));
			LinkedList<String> countries = new LinkedList<String>();
			ToponymSearchResult searchResult;
			try {
				searchResult = WebService.search(searchCriteria);
				for (Toponym toponym : searchResult.getToponyms()) {
					if(toponym != null && toponym.getCountryName()!= null && !countries.contains(toponym.getCountryName().toLowerCase())){
						countries.add(toponym.getCountryName().toLowerCase());
						geo_location.add(location_name, toponym.getLatitude(), toponym.getLongitude(), toponym.getCountryName(), "",name_weight_map.get(location_name));
					}
					
				}
				geo_locations.add(geo_location);
			} catch (Exception e) {
				e.printStackTrace();
				geo_locations.add(null);
			}
		}	
		GeoLocationWithOptions[] geo_locations_array = new GeoLocationWithOptions[geo_locations.size()];
		int i = 0;
		for(GeoLocationWithOptions loc: geo_locations){
			geo_locations_array[i] = loc; i++;
		}
		return geo_locations_array;
	}
	public static void main(String[] args) {
		
	}
}
