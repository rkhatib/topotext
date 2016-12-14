package lb.edu.aub.cmps;

import java.util.LinkedList;

public class GeoLocationWithOptions {

	private String location_name;
	private LinkedList<GeoLocation> geoLocations;
	private int weight;
	public GeoLocationWithOptions(String name) {
		this.location_name = name;
		this.geoLocations = new LinkedList<GeoLocation>();
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public LinkedList<GeoLocation> getGeoLocations() {
		return geoLocations;
	}

	public void setGeoLocations(LinkedList<GeoLocation> geoLocations) {
		this.geoLocations = geoLocations;
	}

	public void add(String name, double x, double y, String country, String alt_names, int weight){
		this.geoLocations.add(new GeoLocation(name, x, y, country, weight));
	}
	
	public int getWeight(){
		return (weight == 0)? 1: weight;

		
	}
	public void setWeight(int weight){
		this.weight = weight;
	}
}
