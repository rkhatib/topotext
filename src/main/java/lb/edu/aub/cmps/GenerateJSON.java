package lb.edu.aub.cmps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import org.json.simple.JSONObject;

public class GenerateJSON {

	@SuppressWarnings("unchecked")
	public static void generateJSON(List<JSONLocation> locations) {
		try {
			PrintStream json_file = new PrintStream(new File("Files\\out.json"));

			JSONObject json = new JSONObject();
			for (JSONLocation location : locations) {
				// name
				json.put("Location Name", location.getLocation_name());
				// geolocations
				JSONObject geo_locations_json = new JSONObject();
				int i = 0;
				for (GeoLocation geo_location : location.getGeoLocations()) {
					geo_locations_json.put("x", geo_location.getX());
					geo_locations_json.put("y", geo_location.getY());
					geo_locations_json
							.put("country", geo_location.getCountry());
					geo_locations_json.put("local annotation",
							location.getLocal_annotations()[i]);
					i++;

				}
				json.put("Geo Locations", geo_locations_json);
				// annotation global
				json.put("Annotation", location.getGlobal_nnotation());
				// weight
				json.put("Weight", location.getWeight());
				json_file.print(json);
				json_file.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
