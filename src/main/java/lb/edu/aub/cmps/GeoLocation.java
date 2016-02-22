package lb.edu.aub.cmps;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import lb.edu.aub.exceptions.LocationNotFoundException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class GeoLocation {
	//OVERVIEW Location is a geographical location that has an x-axis and y-axis coordinates and a country 
	private String location_name;
	private double x; 
	private double y;
	private String country;
	
	/*
	 * requires: loc is not null and doesn't contain spaces
	 * 
	 * throws LocationNotFoundException if there were any problems in getting the coordinates or the country
	 * 
	 * effects: initializes a Location with its characteristics: its x-axis and y-axis coordinates 
	 * 			along with the country its is found to be in 
	 * sketch of implementation: opens a URL connection to google maps 
	 * 							parses a JSON object returned and sets the coordinates and the country 
	 */
	public GeoLocation(String locationName) throws LocationNotFoundException {
		JSONParser parser = new JSONParser();

		try {
			URL url = new URL(
					"https://maps.googleapis.com/maps/api/geocode/json?address="
							+ locationName
							+ "&sensor=true&key=AIzaSyCZh4n_-9uL24erKrgxAofGycqDfiFswBE");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.connect();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			Object obj = parser.parse(reader);
			JSONObject jsonObject = (JSONObject) obj;

			JSONArray results = (JSONArray) jsonObject.get("results");
			JSONObject geometry = ((JSONObject) ((JSONObject) results.get(0))
					.get("geometry"));
			JSONObject location = (JSONObject) geometry.get("location");
			this.x = ((Double) location.get("lat"));
			this.y = ((Double) location.get("lng"));

			JSONArray address_components = ((JSONArray) ((JSONObject) results
					.get(0)).get("address_components"));
			this.country = (String) ((JSONObject) address_components
					.get(address_components.size() - 1)).get("long_name");
			this.location_name=locationName;

		} catch (FileNotFoundException e) {
			throw new LocationNotFoundException();
		} catch (IOException e) {
			throw new LocationNotFoundException();
		} catch (ParseException e) {
			throw new LocationNotFoundException();
		}

		catch(IndexOutOfBoundsException e){
			throw new LocationNotFoundException();
		}
	}

	/**
	 * 
	 * @return the x coordinate
	 */
	public double getX() {
		return x;
	}


	/**
	 * 
	 * @return the y coordinate
	 */
	public double getY() {
		return y;
	}



	/**
	 * 
	 * @return the coutry of this location
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * 
	 * @return the name of this location
	 */
	public String getLocation_name() {
		return location_name;
	}

}
