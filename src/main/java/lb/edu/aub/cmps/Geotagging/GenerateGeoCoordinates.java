package lb.edu.aub.cmps.Geotagging;

import java.util.HashMap;

import lb.edu.aub.cmps.GeoLocationWithOptions;

public interface GenerateGeoCoordinates {

	public GeoLocationWithOptions[] generateGeoLocations(HashMap<String, Integer> name_weight_map);
}
