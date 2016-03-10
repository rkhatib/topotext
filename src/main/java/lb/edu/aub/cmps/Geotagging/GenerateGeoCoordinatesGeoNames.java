package lb.edu.aub.cmps.Geotagging;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import lb.edu.aub.cmps.GeoLocationWithOptions;

import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

public class GenerateGeoCoordinatesGeoNames implements GenerateGeoCoordinates {

	public GeoLocationWithOptions[] generateGeoLocations(String[] locations_name) {
		WebService.setUserName("julia94"); // add your username here
		ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
		
		List<GeoLocationWithOptions> geo_locations = new LinkedList<GeoLocationWithOptions>();

		
		for(String location_name: locations_name){
			searchCriteria.setQ(location_name);
			GeoLocationWithOptions geo_location = new GeoLocationWithOptions(location_name);
			Set<String> countries = new HashSet<String>();
			ToponymSearchResult searchResult;
			try {
				searchResult = WebService.search(searchCriteria);
				for (Toponym toponym : searchResult.getToponyms()) {
					if(!countries.contains(toponym.getCountryName().toLowerCase())){
						countries.add(toponym.getCountryName().toLowerCase());
						geo_location.add(location_name, toponym.getLatitude(), toponym.getLongitude(), toponym.getCountryName());
					}
					
				}
				geo_locations.add(geo_location);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				geo_locations.add(null);
			}
		}	
		return (GeoLocationWithOptions[]) geo_locations.toArray();
	}
}
